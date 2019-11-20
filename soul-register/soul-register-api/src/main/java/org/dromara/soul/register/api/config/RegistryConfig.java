/*
 *     Licensed to the Apache Software Foundation (ASF) under one or more
 *     contributor license agreements.See the NOTICE file distributed with
 *     this work for additional information regarding copyright ownership.
 *     The ASF licenses this file to You under the Apache License, Version 2.0
 *     (the "License"); you may not use this file except in compliance with
 *     the License.You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.dromara.soul.register.api.config;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.dromara.soul.common.extension.Join;
import org.dromara.soul.common.http.URL;
import org.dromara.soul.config.api.AbstractConfig;
import org.dromara.soul.register.api.RegisterConst;

/**
 * RegistryConfig
 * 1. Some configuration processing of registration information.
 * 2. url Registration is processed according to different protocols.
 * 3. case: zookeeper://192.168.1.32:1281?cluster=192.168.1.33:1281,192.168.1.34:1281
 *
 * @author sixh
 */
@Data
@Join
public class RegistryConfig extends AbstractConfig {

    private String url;

    /**
     * Gets cluster to getParameters.
     *
     * @return the cluster
     */
    @SuppressWarnings("all")
    public static List<String> getCluster(URL url) {
        String cluster = url.getParameters().get(RegisterConst.URL_CLUSTER_KEY);
        List<String> lists = Splitter.on(RegisterConst.URL_SPLIT_SYMBOL_KEY).splitToList(cluster);
        return new ArrayList<>(lists);
    }

    @Override
    public String prefix() {
        return "soul.registry";
    }
}
