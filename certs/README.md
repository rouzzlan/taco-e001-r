# Import cert with keytool
```bash
sudo keytool -import -alias keycloak-dev-1 -keystore /usr/lib/jvm/java/lib/security/cacerts -file ca-cert.pem
```
enter password `changeit` and if ok enter `yes`.