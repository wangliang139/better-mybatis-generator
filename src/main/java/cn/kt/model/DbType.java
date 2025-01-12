package cn.kt.model;

public enum DbType {

    MySQL("com.mysql.jdbc.Driver", "jdbc:mysql://%s:%s/%s?useUnicode=true&useSSL=false&characterEncoding=%s", "mysql-connector-java-5.1.38.jar"),
    MySQL_8("com.mysql.cj.jdbc.Driver", "jdbc:mysql://%s:%s/%s?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=%s", "mysql-connector-java-8.0.11.jar"),
    Oracle("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@%s:%s:%s", "ojdbc14.jar"),
    PostgreSQL("org.postgresql.Driver", "jdbc:postgresql://%s:%s/%s", "postgresql-9.4.1209.jar"),
    SqlServer("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://%s:%s;databaseName=%s", "sqljdbc4-4.0.jar"),
    Sqlite("org.sqlite.JDBC", "jdbc:sqlite:%s", "sqlite-jdbc-3.19.3.jar"),
    MariaDB("org.mariadb.jdbc.Driver", "", "mariadb-java-client-2.3.0.jar");

    private final String driverClass;
    private final String connectionUrlPattern;
    private final String connectorJarFile;

    DbType(String driverClass, String connectionUrlPattern, String connectorJarFile) {
        this.driverClass = driverClass;
        this.connectionUrlPattern = connectionUrlPattern;
        this.connectorJarFile = connectorJarFile;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getConnectionUrlPattern() {
        return connectionUrlPattern;
    }

    public String getConnectorJarFile() {
        return connectorJarFile;
    }
}