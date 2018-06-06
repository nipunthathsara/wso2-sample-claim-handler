# WSO2 Custom Claim Handler
## To set a default value to claims

1. Build with mvn clean install
2. Paste the jar to <IS_HOME>/repository/component/dropins directory
3. Change <IS_HOME>/repository/conf/identity/application-authenticator.xml as below

   ```xml
   <ClaimHandler>org.wso2.custom.claim.PermissionReceiver</ClaimHandler>
   ```
4. Restart the server
