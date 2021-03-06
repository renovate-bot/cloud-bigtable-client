/*
 * Copyright 2015 Google LLC
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
package com.google.cloud.bigtable.grpc.io;

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import io.grpc.Status;
import java.io.IOException;

/** An IOException that carries a gRPC Status object. */
@InternalExtensionOnly
public class IOExceptionWithStatus extends IOException {
  private static final long serialVersionUID = 1L;
  private final Status status;

  /**
   * Constructor for IOExceptionWithStatus.
   *
   * <p>For internal use only - public for technical reasons.
   */
  @InternalApi("For internal usage only")
  public IOExceptionWithStatus(String message, Throwable cause, Status status) {
    super(message, cause);
    this.status = status;
  }

  /**
   * Constructor for IOExceptionWithStatus.
   *
   * <p>For internal use only - public for technical reasons.
   */
  @InternalApi("For internal usage only")
  public IOExceptionWithStatus(String message, Status status) {
    this(message, status.asRuntimeException(), status);
  }

  /**
   * Status from the provided OperationRuntimeException.
   *
   * @return a {@link io.grpc.Status} object.
   */
  public Status getStatus() {
    return status;
  }
}
