package org.apache.lens.server.api;

/*
 * #%L
 * Lens API for server and extensions
 * %%
 * Copyright (C) 2014 Apache Software Foundation
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.apache.hive.service.Service;

/**
 * The Interface ServiceProvider.
 */
public interface ServiceProvider {

  /**
   * Get an instance of a service by its name.
   *
   * @param <T>
   *          the generic type
   * @param sName
   *          the s name
   * @return the service
   */
  public <T extends Service> T getService(String sName);
}
