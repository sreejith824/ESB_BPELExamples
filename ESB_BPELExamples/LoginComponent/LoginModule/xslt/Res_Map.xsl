<?xml version="1.0" encoding="UTF-8"?>
<!-- @generated mapFile="xslt/Res_Map.map" md5sum="2a7b4848937fd3e57a1f24cad362c2ca" version="8.0.200" -->
<!--
*****************************************************************************
*   This file has been generated by the IBM XML Mapping Editor.
*
*   Mapping file:		Res_Map.map
*   Map declaration(s):	Res_Map
*   Input file(s):		smo://smo/name%3Dwsdl-primary/message%3D%257Bhttp%253A%252F%252FLoginModule%252FLoginComponentReference%257DloginResponseMsg/xpath%3D%252Fbody/smo.xsd
*   Output file(s):		smo://smo/name%3Dwsdl-primary/message%3D%257Bhttp%253A%252F%252FLoginModule%252FLoginModuleInterface%257DloginUserResponseMsg/xpath%3D%252Fbody/smo.xsd
*
*   Note: Do not modify the contents of this file as it is overwritten
*         each time the mapping model is updated.
*****************************************************************************
-->
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xalan="http://xml.apache.org/xslt"
    xmlns:str="http://exslt.org/strings"
    xmlns:set="http://exslt.org/sets"
    xmlns:math="http://exslt.org/math"
    xmlns:exsl="http://exslt.org/common"
    xmlns:date="http://exslt.org/dates-and-times"
    xmlns:in="wsdl.http://LoginModule/LoginComponentReference"
    xmlns:in2="http://LoginModule/LoginComponentReference"
    xmlns:out="http://LoginModule/LoginModuleInterface"
    xmlns:io="http://www.w3.org/2003/05/soap-envelope"
    xmlns:io3="http://www.ibm.com/xmlns/prod/websphere/mq/sca/6.0.0"
    xmlns:io2="http://www.ibm.com/websphere/sibx/smo/v6.0.1"
    xmlns:out2="wsdl.http://LoginModule/LoginModuleInterface"
    xmlns:io4="http://schemas.xmlsoap.org/ws/2004/08/addressing"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:io5="http://www.ibm.com/xmlns/prod/websphere/http/sca/6.1.0"
    xmlns:xs4xs="http://www.w3.org/2001/XMLSchema"
    xmlns:io6="http://www.w3.org/2005/08/addressing"
    xmlns:map="http://LoginModule/xslt/Res_Map"
    xmlns:msl="http://www.ibm.com/xmlmap"
    exclude-result-prefixes="in in2 str set math exsl date map xalan msl"
    version="1.0">
  <xsl:output method="xml" encoding="UTF-8" indent="no"/>

  <!-- root wrapper template  -->
  <xsl:template match="/">
    <xsl:choose>
      <xsl:when test="msl:datamap">
        <msl:datamap>
          <xsl:element name="dataObject">
            <xsl:attribute name="xsi:type">
              <xsl:value-of select="'out2:loginUserResponseMsg'"/>
            </xsl:attribute>
            <xsl:call-template name="map:Res_Map2">
              <xsl:with-param name="body" select="msl:datamap/dataObject[1]"/>
            </xsl:call-template>
          </xsl:element>
        </msl:datamap>
      </xsl:when>
      <xsl:otherwise>
        <xsl:apply-templates select="body" mode="map:Res_Map"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <!-- This rule represents an element mapping: "body" to "body".  -->
  <xsl:template match="body"  mode="map:Res_Map">
    <body>
      <xsl:attribute name="xsi:type">
        <xsl:value-of select="'out2:loginUserResponseMsg'"/>
      </xsl:attribute>
      <out:loginUserResponse>
        <!-- a simple data mapping: "in2:loginResponse/loginMesssage"(string) to "loginMessage"(string) -->
        <xsl:choose>
          <xsl:when test="normalize-space(in2:loginResponse/loginMesssage)">
            <xsl:element name="loginMessage">
              <xsl:value-of select="in2:loginResponse/loginMesssage"/>
            </xsl:element>
          </xsl:when>
          <xsl:otherwise>
            <loginMessage xsi:nil="true"/>
          </xsl:otherwise>
        </xsl:choose>
      </out:loginUserResponse>
    </body>
  </xsl:template>

  <!-- This rule represents a type mapping: "body" to "body".  -->
  <xsl:template name="map:Res_Map2">
    <xsl:param name="body"/>
    <out:loginUserResponse>
      <!-- a simple data mapping: "$body/in2:loginResponse/loginMesssage"(string) to "loginMessage"(string) -->
      <xsl:choose>
        <xsl:when test="normalize-space($body/in2:loginResponse/loginMesssage)">
          <xsl:element name="loginMessage">
            <xsl:value-of select="$body/in2:loginResponse/loginMesssage"/>
          </xsl:element>
        </xsl:when>
        <xsl:otherwise>
          <loginMessage xsi:nil="true"/>
        </xsl:otherwise>
      </xsl:choose>
    </out:loginUserResponse>
  </xsl:template>

  <!-- *****************    Utility Templates    ******************  -->
  <!-- copy the namespace declarations from the source to the target -->
  <xsl:template name="copyNamespaceDeclarations">
    <xsl:param name="root"/>
    <xsl:for-each select="$root/namespace::*[not(name() = '')]">
      <xsl:copy/>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
