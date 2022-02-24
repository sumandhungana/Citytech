FROM openjdk:17-alpine
# Set the WILDFLY_VERSION env variable
ENV WILDFLY_SOURCE wildfly-crm.zip
ENV WILDFLY_ROOT wildfly-preview-25.0.1.Final
ARG TIME_ZONE
RUN apk add tzdata && cp /usr/share/zoneinfo/$TIME_ZONE /etc/localtime && echo "$TIME_ZONE" > /etc/timezone
RUN mkdir -p /opt/jboss/
ENV JBOSS_HOME /opt/jboss/wildfly/
#RUN apk --no-cache add curl
RUN apk --no-cache add wget

#ADD public-endpoints/target/public-endpoints.war  /opt/jboss/wildfly-25.0.0.Final/standalone/deployments/public-endpoints.war

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd /opt/jboss/ \
    && pwd \
    && ls -lah \
    && wget ftp://ftp.drose.com.np/$WILDFLY_SOURCE \
    && ls -lah \
    && unzip $WILDFLY_SOURCE \
    && mv $WILDFLY_ROOT wildfly \
    && ls -lah \
    && rm $WILDFLY_SOURCE

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true
ENV TIME_ZONE="$TIME_ZONE"

ENV JNDI_NAME java:jboss/datasource/crmDS
ENV DS_POOL_NAME CRMPOOL
ENV DB_HOST 172.16.128.37
ENV DB_PORT 5432
ENV DB_USER_NAME remitpulse
ENV DB_PASSWORD remitpulse@123

# Expose the ports in which we're interested
EXPOSE 8080

# Deploy War File
COPY admin-endpoints/target/admin-endpoints.war  $JBOSS_HOME/standalone/deployments/admin-endpoints.war
COPY admin-web/target/admin-web.war  $JBOSS_HOME/standalone/deployments/admin-web.war

# Set the default command to run on boot
# This will boot WildFly in standalone mode and bind to all interfaces
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0","-c","standalone-full.xml"]