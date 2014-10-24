package org.apache.lens.driver.hive;

/*
 * #%L
 * Lens Hive Driver
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

import org.apache.hadoop.fs.Path;
import org.apache.hive.service.cli.*;
import org.apache.lens.api.LensException;
import org.apache.lens.server.api.driver.LensResultSetMetadata;
import org.apache.lens.server.api.driver.PersistentResultSet;

/**
 * The Class HivePersistentResultSet.
 */
public class HivePersistentResultSet extends PersistentResultSet {

  /** The path. */
  private final Path path;

  /** The metadata. */
  private final TableSchema metadata;

  /**
   * Instantiates a new hive persistent result set.
   *
   * @param resultSetPath
   *          the result set path
   * @param opHandle
   *          the op handle
   * @param client
   *          the client
   * @throws HiveSQLException
   *           the hive sql exception
   */
  public HivePersistentResultSet(Path resultSetPath, OperationHandle opHandle, CLIServiceClient client)
      throws HiveSQLException {
    this.path = resultSetPath;
    this.metadata = client.getResultSetMetadata(opHandle);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.lens.server.api.driver.LensResultSet#size()
   */
  @Override
  public int size() throws LensException {
    return -1;
  }

  @Override
  public String getOutputPath() throws LensException {
    return path.toString();
  }

  @Override
  public LensResultSetMetadata getMetadata() throws LensException {
    // Removed Anonymous inner class and changed it to concrete class
    // for serialization to JSON
    HiveResultSetMetadata hrsMeta = new HiveResultSetMetadata();
    hrsMeta.setColumns(metadata.getColumnDescriptors());
    return hrsMeta;
  }
}
