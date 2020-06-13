module samples {
    requires javafx.graphics;
    requires kotlin.stdlib;
    requires bootfx.core;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires javafx.controls;
    requires org.slf4j;

    exports com.johupe.samples to javafx.graphics;
    exports com.johupe.samples.controller to spring.beans, spring.core, spring.context, bootfx.core;
    exports com.johupe.samples.application to spring.beans, spring.core, spring.context;
    exports com.johupe.samples.config to spring.beans, spring.core, spring.context;
    opens com.johupe.samples to spring.core, spring.beans, spring.context;
    opens com.johupe.samples.controller to spring.core, spring.beans, spring.context, bootfx.core;
    opens com.johupe.samples.application to spring.core, spring.beans, spring.context;
    opens com.johupe.samples.config to spring.core, spring.beans, spring.context;
}