package cn.tj.fnzi;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author Rob Winch
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {

    public Initializer() {
        super(Config.class);
    }
}