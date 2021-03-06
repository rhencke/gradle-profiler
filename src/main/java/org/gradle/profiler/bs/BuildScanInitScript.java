/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.profiler.bs;

import org.gradle.profiler.GeneratedInitScript;

import java.io.IOException;
import java.io.PrintWriter;

public class BuildScanInitScript extends GeneratedInitScript {
    public final static String VERSION = "1.6";

    private final String version;

    public BuildScanInitScript(String version) throws IOException {
        super();
        this.version = version == null ? VERSION : version;
        generateInitScript();
        System.out.println("Using build scan profiler version " + this.version);
    }

    @Override
    public void writeContents(final PrintWriter writer) {
        writer.write("initscript {\n");
        writer.write("    repositories {\n");
        writer.write("      maven {\n");
        writer.write("          url \"https://plugins.gradle.org/m2\"\n");
        writer.write("        }\n");
        writer.write("    }\n");
        writer.write("    dependencies {\n");
        writer.write("        classpath \"com.gradle:build-scan-plugin:" + version + "\"\n");
        writer.write("    }\n");
        writer.write("}\n");
        writer.write("\n");
        writer.write("rootProject { prj ->\n");
        writer.write("    apply plugin: initscript.classLoader.loadClass(\"com.gradle.scan.plugin.BuildScanPlugin\")\n");
        writer.write("    buildScan {\n");
        writer.write("        licenseAgreementUrl = 'https://gradle.com/terms-of-service'\n");
        writer.write("        licenseAgree = 'yes'\n");
        writer.write("        publishAlways()\n");
        writer.write("    }\n");
        writer.write("}\n");
    }


}
