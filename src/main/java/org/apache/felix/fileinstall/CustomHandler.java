/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.fileinstall;

import java.util.List;
import java.util.Properties;

/**
 * Implementors of this interface are used to handle FileInstall artifacts.
 * 
 * @author Sergiy Shyrkov
 */
public interface CustomHandler {

    String PROP_ID = "felix.fileinstall.customHandler";

    /**
     * Returns the bundle location mappings, i.e. a transformed location to a real file path location. If this handler does not maintain
     * mappings, <code>null</code> is returned.
     * 
     * @return the bundle location mappings, i.e. a transformed location to a real file path location. If this handler does not maintain
     *         mappings, <code>null</code> is returned
     */
    Properties getBundleLocationMapping();

    /**
     * Process the artifacts from FileInstall.
     * 
     * @param created the list of created artifacts
     * @param modified the list of artifacts which were modified
     * @param deleted the list of deleted artifacts
     */
    void process(List<Artifact> created, List<Artifact> modified, List<Artifact> deleted);

    /**
     * Removed the data (JAR file and possibly transformed JAR file) for the specified bundle artifact as we got an event that bundle was
     * uninstalled.
     * 
     * @param artifact the bundle artifact to remove data for
     */
    void removeUninstalledBundleData(Artifact artifact);

    /**
     * Is called by the file install watcher to "say" that it has started and perform initial processing of the artifacts.
     */
    void watcherStarted();

}
