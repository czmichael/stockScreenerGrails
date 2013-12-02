import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='database-migration', version='1.2.1')
class gsp_databaseMigration_dbdoc_index_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/database-migration-1.2.1/grails-app/views/dbdoc/_index.gsp" }
public Object run() {
Writer out = getOut()
Writer codecOut = getCodecOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(3)
codecOut.print(createLink(action: 'globalnav'))
printHtmlPart(4)
codecOut.print(createLink(action: 'currenttables'))
printHtmlPart(5)
codecOut.print(createLink(action: 'overview-summary'))
printHtmlPart(6)
codecOut.print(createLink(action: 'overview-summary'))
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1354396548000L
public static final String DEFAULT_CODEC = null
}
