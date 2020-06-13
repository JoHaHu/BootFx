open module bootfx.core {
    requires spring.context;
    requires spring.boot;
    requires transitive  javafx.controls;
    requires kotlin.stdlib;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires org.slf4j;
    exports com.johupe.bootfx;
    exports com.johupe.bootfx.config;
    exports com.johupe.bootfx.dsl;
}