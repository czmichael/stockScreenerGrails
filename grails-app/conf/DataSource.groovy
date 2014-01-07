dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = ""
	dialect = org.hibernate.dialect.MySQL5InnoDBDialect
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}

// environment specific settings
environments {
    development {
        dataSource {
			// one of 'create', 'create-drop', 'update', 'validate', ''
            dbCreate = "update" 
            url = "jdbc:mysql://127.0.0.1:3306/finance"
        }
		hibernate {
			show_sql = true
		}
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://127.0.0.1:3306/finance"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://127.0.0.1:3306/finance"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
