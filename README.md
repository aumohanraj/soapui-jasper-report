# soapui-jasper-report
Jasper reports for SoapUI open source.
Sample report available in samples folder.

# How to install in SoapUI
1. Copy dist/soapui-jasper-report-jar-with-dependencies.jar file to C:\Program Files (x86)\SmartBear\SoapUI-5.5.0\bin\ext\.
2. Copy listener-xml/jasper-listeners.xml to C:\Program Files (x86)\SmartBear\SoapUI-5.5.0\bin\listeners.
3. Restart SoapUI with administrative privileges.
4. Run your SoapUI project and see report in C:\Program Files (x86)\SmartBear\SoapUI-5.5.0\bin\reportsOutput\ folder.

Note : Start SoapUI with administrative privileges. Administrator priviliges required, to create report inside SoapUI-5.5.0\bin\reportsOuput\ folder.

# How to build
1. Add http://www.soapui.org/repository/maven2/ to maven repository before starting the build. This is required to get SoapUI dependencies.
2. Run mvn clean install to build.
