package jp.co.everrise.tester;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ExceptionConfig;
import org.apache.struts.config.ForwardConfig;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.util.PropertyMessageResourcesFactory;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.annotation.tiger.InitMethod;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.framework.convention.NamingConvention;
import org.seasar.framework.mock.servlet.MockHttpServletRequest;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.action.S2RequestProcessor;
import org.seasar.struts.config.S2ActionMapping;
import org.seasar.struts.config.S2ExecuteConfig;
import org.seasar.struts.config.S2ModuleConfig;
import org.seasar.struts.util.ActionUtil;
import org.seasar.struts.util.RoutingUtil;
import org.seasar.struts.util.S2ExecuteConfigUtil;
import org.seasar.struts.validator.S2ValidatorPlugIn;

/**
 * Actionテスター.
 * 
 */
public class ActionTester{

    @Resource
    protected NamingConvention nc;
    @Resource
    protected ServletContext servletContext;
    @Resource
    public MockHttpServletRequest request;
    @Resource
    public MockHttpServletResponse response;

    protected S2ModuleConfig moduleConfig;

    protected String validationRulePath = "validator-rules.xml";

    private String destPath;

    @InitMethod
    public void setUp() throws Exception{
        request.setMethod("GET");
        moduleConfig = new S2ModuleConfig("");
        servletContext.setAttribute(Globals.MODULE_KEY, moduleConfig);

        S2ValidatorPlugIn vp = new S2ValidatorPlugIn();
        vp.setPathnames(validationRulePath);
        vp.init(new ActionServlet(){
            private static final long serialVersionUID = 1L;

            @Override
            public ServletContext getServletContext(){
                return servletContext;
            }
        }, moduleConfig);

        servletContext.setAttribute(Globals.MESSAGES_KEY, PropertyMessageResourcesFactory.createFactory()
                .createResources("application.properties"));
    }

    public void tearDown(){
        moduleConfig = null;
        destPath = null;
    }

    /**
     * Returns the request parameter.
     * 
     * @param name
     *            the parameter name
     * @return the parameter value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public String param(CharSequence name) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        return request.getParameter(name.toString());
    }

    /**
     * Sets the request parameter.
     * 
     * @param name
     *            the parameter name
     * @param value
     *            the parameter value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public void param(CharSequence name, Object value) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        request.setParameter(name.toString(), (String)value);
    }

    /**
     * Returns the request parameter.
     * 
     * @param name
     *            the parameter name
     * @return the parameter value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public String[] paramValues(CharSequence name) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        return request.getParameterValues(name.toString());
    }

    /**
     * Sets the request parameter.
     * 
     * @param name
     *            the parameter name
     * @param value
     *            the parameter value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public void paramValues(CharSequence name, String[] value) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        request.setParameter(name.toString(), value);
    }

    /**
     * Returns the request attribute.
     * 
     * @param <T>
     *            the return type
     * @param name
     *            the attribute name
     * @return the request attribute
     * @throws NullPointerException
     *             if the name parameter is null
     */
    @SuppressWarnings("unchecked")
    public <T> T requestScope(CharSequence name) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        return (T) request.getAttribute(name.toString());
    }

    /**
     * Sets the request attribute.
     * 
     * @param name
     *            the attribute name
     * @param value
     *            the attribute value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public void requestScope(CharSequence name, Object value) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        request.setAttribute(name.toString(), value);
    }

    /**
     * Returns the session attribute.
     * 
     * @param <T>
     *            the return type
     * @param name
     *            the attribute name
     * @return the attribute value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    @SuppressWarnings("unchecked")
    public <T> T sessionScope(CharSequence name) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        HttpSession session = request.getSession(false);
        if(session == null){
            return null;
        }
        return (T) session.getAttribute(name.toString());
    }

    /**
     * Sets the session attribute.
     * 
     * @param name
     *            the attribute name
     * @param value
     *            the attribute value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public void sessionScope(CharSequence name, Object value) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        request.getSession().setAttribute(name.toString(), value);
    }

    /**
     * Returns the servlet context attribute.
     * 
     * @param <T>
     *            the return type
     * @param name
     *            the attribute name
     * @return the attribute value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    @SuppressWarnings("unchecked")
    public <T> T applicationScope(CharSequence name) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        return (T) servletContext.getAttribute(name.toString());
    }

    /**
     * Sets the servlet context attribute.
     * 
     * @param name
     *            the attribute name
     * @param value
     *            the attribute value
     * @throws NullPointerException
     *             if the name parameter is null
     */
    public void applicationScope(CharSequence name, Object value) throws NullPointerException{
        if(name == null){
            throw new NullPointerException("The name parameter must not be null.");
        }
        servletContext.setAttribute(name.toString(), value);
    }

    /**
     * 指定バスのActionメソッドを実行します.
     * 
     * @param path
     *            パス
     * @return Actionメソッドの戻り値
     */
    public void start(String path){
        response.setStatus(HttpServletResponse.SC_OK);
        String actionPath = routing(path);
        if(actionPath == null){
            fail("routing error.");
        }
        MockS2RequestProcessor processor = new MockS2RequestProcessor(moduleConfig);
        SingletonS2Container.getComponent(ActionUtil.fromPathToActionName(actionPath));
        try{
            S2ActionMapping mapping = (S2ActionMapping) processor.processMapping(request, response, actionPath);
            if(mapping == null){
                fail("action mapping not found.");
            }
            mapping = new MockS2ActionMapping(mapping);
            processor.processExecuteConfig(request, response, mapping);
            ActionForm form = processor.processActionForm(request, response, mapping);
            processor.processPopulate(request, response, form, mapping);
            Action action = processor.processActionCreate(request, response, mapping);
            ActionForward forward = processor.processActionPerform(request, response, action, form, mapping);
            processor.exportPropertiesToRequest(request, mapping, S2ExecuteConfigUtil.getExecuteConfig());
            destPath = forward != null ? forward.getPath() : null;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Actionメソッドの戻り値を返します.
     * 
     * @return Actionメソッドの戻り値
     */
    public String getDestinationPath(){
        return destPath;
    }

    /**
     * {@link ActionMessages}を返します.
     * 
     * @return ActionMessages
     */
    public ActionMessages getErrors(){
        return (ActionMessages) request.getAttribute(Globals.ERROR_KEY);
    }

    /**
     * 全ての{@link ActionMessage}を返します.
     * 
     * @return ActionMessageのリスト
     */
    @SuppressWarnings("unchecked")
    public List<ActionMessage> getErrorsMessage(){
        if(getErrors() == null || getErrors().isEmpty()){
            return Collections.emptyList();
        }

        List<ActionMessage> list = new ArrayList<ActionMessage>();
        for(Iterator<ActionMessage> ite = (Iterator<ActionMessage>) getErrors().get(); ite.hasNext();){
            list.add(ite.next());
        }
        return list;
    }

    /**
     * {@link ActionMessage}のリストを返します.
     * 
     * @param key
     *            取得するActionMessageのキー
     * @return ActionMessageのリスト
     */
    @SuppressWarnings("unchecked")
    public List<ActionMessage> getErrorsMessage(String key){
        if(getErrors() == null || getErrors().isEmpty()){
            return Collections.emptyList();
        }

        List<ActionMessage> list = new ArrayList<ActionMessage>();
        for(Iterator<ActionMessage> ite = (Iterator<ActionMessage>) getErrors().get(key); ite.hasNext();){
            list.add(ite.next());
        }
        return list;
    }

    private static class MockS2ActionMapping extends S2ActionMapping{
        private static final long serialVersionUID = 1L;

        public MockS2ActionMapping(S2ActionMapping org){
            this.actionBeanDesc = org.getActionBeanDesc();
            this.actionFormBeanDesc = org.getActionFormBeanDesc();
            this.actionFormComponentDef = org.getActionFormComponentDef();
            this.actionFormField = org.getActionFormField();
            this.attribute = org.getAttribute();
            this.cancellable = org.getCancellable();
            this.componentDef = org.getComponentDef();

            for(ExceptionConfig config : org.findExceptionConfigs()){
                addExceptionConfig(config);
            }
            for(String key : org.getExecuteMethodNames()){
                addExecuteConfig(org.getExecuteConfig(key));
            }
            this.forward = org.getForward();
            for(ForwardConfig forwardConfig : findForwardConfigs()){
                addForwardConfig(forwardConfig);
            }
            this.configured = true;
            this.include = org.getInclude();
            this.input = org.getInput();
            this.moduleConfig = org.getModuleConfig();
            this.name = org.getName();
            this.parameter = org.getParameter();
            this.path = org.getPath();
            this.prefix = org.getPrefix();
            this.roleNames = org.getRoleNames();
            this.roles = org.getRoles();
            this.scope = org.getScope();
            this.suffix = org.getSuffix();
            this.type = org.getType();
            this.unknown = org.getUnknown();
            this.validate = org.getValidate();
        }

        @Override
        public ActionForward createForward(String path, boolean redirect){
            return new ActionForward(path, redirect);
        }
    }

    private static class MockS2RequestProcessor extends S2RequestProcessor{

        public MockS2RequestProcessor(ModuleConfig moduleConfig){
            this.moduleConfig = moduleConfig;
        }

        @Override
        protected ActionForward processActionPerform(HttpServletRequest request, HttpServletResponse response,
                Action action, ActionForm form, ActionMapping mapping) throws IOException, ServletException{
            return super.processActionPerform(request, response, action, form, mapping);
        }

        @Override
        protected Action processActionCreate(HttpServletRequest request, HttpServletResponse response,
                ActionMapping mapping) throws IOException{
            return super.processActionCreate(request, response, mapping);
        }

        @Override
        protected ActionForm processActionForm(HttpServletRequest request, HttpServletResponse response,
                ActionMapping mapping){
            return super.processActionForm(request, response, mapping);
        }

        @Override
        protected void processExecuteConfig(HttpServletRequest request, HttpServletResponse response,
                ActionMapping mapping){
            super.processExecuteConfig(request, response, mapping);
        }

        @Override
        protected ActionMapping processMapping(HttpServletRequest request, HttpServletResponse response, String path)
                throws IOException{
            return super.processMapping(request, response, path);
        }

        @Override
        protected void processPopulate(HttpServletRequest request, HttpServletResponse response, ActionForm form,
                ActionMapping mapping) throws ServletException{
            super.processPopulate(request, response, form, mapping);
        }

        @Override
        protected void exportPropertiesToRequest(HttpServletRequest request, S2ActionMapping actionMapping,
                S2ExecuteConfig executeConfig){
            super.exportPropertiesToRequest(request, actionMapping, executeConfig);
        }
    }

    private String routing(String path){
        if(path.indexOf('.') < 0){
            String[] names = StringUtil.split(path, "/");
            S2Container container = SingletonS2ContainerFactory.getContainer();
            StringBuilder sb = new StringBuilder(50);
            for(int i = 0; i < names.length; i++){
                if(container.hasComponentDef(sb + names[i] + "Action")){
                    String actionPath = RoutingUtil.getActionPath(names, i);
                    String paramPath = RoutingUtil.getParamPath(names, i + 1);
                    if(StringUtil.isEmpty(paramPath)){
                        if(!path.endsWith("/")){
                            return path;
                        }else if(S2ExecuteConfigUtil.findExecuteConfig(actionPath, request) != null){
                            return actionPath;
                        }
                    }else{
                        S2ExecuteConfig executeConfig = S2ExecuteConfigUtil.findExecuteConfig(actionPath, paramPath);
                        if(executeConfig != null){
                            setParam(paramPath, executeConfig);
                            return actionPath;
                        }
                    }
                }
                if(container.hasComponentDef(sb + "indexAction")){
                    String actionPath = RoutingUtil.getActionPath(names, i - 1) + "/index";
                    String paramPath = RoutingUtil.getParamPath(names, i);
                    if(StringUtil.isEmpty(paramPath)){
                        if(!path.endsWith("/")){
                            return path;
                        }else if(S2ExecuteConfigUtil.findExecuteConfig(actionPath, request) != null){
                            return actionPath;
                        }
                    }else{
                        S2ExecuteConfig executeConfig = S2ExecuteConfigUtil.findExecuteConfig(actionPath, paramPath);
                        if(executeConfig != null){
                            setParam(paramPath, executeConfig);
                            return actionPath;
                        }
                    }
                }
                sb.append(names[i] + "_");
            }
            if(container.hasComponentDef(sb + "indexAction")){
                String actionPath = RoutingUtil.getActionPath(names, names.length - 1) + "/index";
                if(!path.endsWith("/")){
                    return path;
                }else if(S2ExecuteConfigUtil.findExecuteConfig(actionPath, request) != null){
                    return actionPath;
                }
            }
        }
        return null;
    }

    private void setParam(String paramPath, S2ExecuteConfig executeConfig){
        String[] querys = executeConfig.getQueryString(paramPath).substring(1).split("&");
        for(String query : querys){
            String[] keyValue = query.split("=");
            request.setParameter(keyValue[0], keyValue[1]);
        }
    }
}
