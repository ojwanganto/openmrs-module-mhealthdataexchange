package org.openmrs.module.mhealthdataexchange.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/${rootArtifactid}/${rootArtifactid}Link.form'.
 */

@Controller("${rootrootArtifactid}.MhealthdataexchangeMhealthMessageController")
@RequestMapping(value = "module/${rootArtifactid}/${rootArtifactid}.form")
public class MhealthdataexchangeMhealthMessageController {
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    UserService userService;
    /** Success form view name */
    private final String VIEW = "/module/${rootArtifactid}/${rootArtifactid}";
    /**
     * Initially called after the getUsers method to get the landing form name
     *
     * @return String form view name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String onGet() {
        return VIEW;
    }
    /**
     * All the parameters are optional based on the necessity
     *
     * @param httpSession
     * @param anyRequestObject
     * @param errors
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String onPost(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
                         BindingResult errors) {

        if (errors.hasErrors()) {
            // return error view
        }
        return VIEW;
    }

    /**
     * This class returns the form backing object. This can be a string, a boolean, or a normal java
     * pojo. The bean name defined in the ModelAttribute annotation and the type can be just defined
     * by the return type of this method
     */
    @ModelAttribute("users")
    protected List<User> getUsers() throws Exception {
        List<User> users = userService.getAllUsers();

        // this object will be made available to the jsp page under the variable name
        // that is defined in the @ModuleAttribute tag
        return users;
    }
}
