package org.wso2.custom.claim;

import org.wso2.carbon.identity.application.authentication.framework.config.model.StepConfig;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.handler.claims.impl.DefaultClaimHandler;
import org.wso2.carbon.identity.application.authentication.framework.exception.FrameworkException;

import java.util.Map;

public class ClaimHandler extends DefaultClaimHandler  {
    private static volatile ClaimHandler instance = null;
    private static String claim = "scope";
    private static String value = "xxxxxxxxxxxxxxxx";

    public static ClaimHandler getInstance() {
        if (instance == null) {
            synchronized (ClaimHandler.class) {
                if (instance == null) {
                    instance = new ClaimHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public Map<String, String> handleClaimMappings(StepConfig stepConfig,
                                                   AuthenticationContext context, Map<String, String> remoteClaims,
                                                   boolean isFederatedClaims) throws FrameworkException {

        Map<String, String> claimMappings = super.handleClaimMappings(stepConfig, context, remoteClaims, isFederatedClaims);
        if(claimMappings.containsKey(claim)){
            claimMappings.put(claim, value);
        }
        return claimMappings;
    }
}
