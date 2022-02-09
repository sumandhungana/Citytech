package global.citytech.interns.crm.adminweb.config;

import global.citytech.interns.crm.adminweb.users.controllers.UserController;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("secured")
public class SecuredMvcConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(UserController.class);
        return classes;
    }

    /**
     *
     *
     * ViewEngine.VIEW_FOLDER
     *
     * Csrf.CSRF_PROTECTION
     *
     * Csrf.CSRF_HEADER_NAME
     *
     *
     *
     * @Override public Map<String, Object> getProperties() { final Map<String, Object> map = new HashMap<>();
     * map.put(ViewEngine.VIEW_FOLDER, "/jsp/"); return map; }
     */
}
