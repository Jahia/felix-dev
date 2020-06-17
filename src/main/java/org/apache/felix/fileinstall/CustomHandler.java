/**
 * ==========================================================================================
 * =                   JAHIA'S DUAL LICENSING - IMPORTANT INFORMATION                       =
 * ==========================================================================================
 *
 *                                 http://www.jahia.com
 *
 *     Copyright (C) 2002-2016 Jahia Solutions Group SA. All rights reserved.
 *
 *     THIS FILE IS AVAILABLE UNDER TWO DIFFERENT LICENSES:
 *     1/GPL OR 2/JSEL
 *
 *     1/ GPL
 *     ==================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE GPL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     2/ JSEL - Commercial and Supported Versions of the program
 *     ===================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE JSEL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     Alternatively, commercial and supported versions of the program - also known as
 *     Enterprise Distributions - must be used in accordance with the terms and conditions
 *     contained in a separate written agreement between you and Jahia Solutions Group SA.
 *
 *     If you are unsure which license is appropriate for your use,
 *     please contact the sales department at sales@jahia.com.
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
