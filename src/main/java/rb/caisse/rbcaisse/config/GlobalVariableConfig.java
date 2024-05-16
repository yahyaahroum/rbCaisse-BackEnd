package rb.caisse.rbcaisse.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.path")
public class GlobalVariableConfig {

    private String globalVariable ;


    public String getGlobalVariable() {
        return globalVariable;
    }

    public void setGlobalVariable(String globalVariable) {
        this.globalVariable = globalVariable;
    }
}