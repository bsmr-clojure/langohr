// Copyright (c) 2011-2014 Michael S. Klishin
//
// The use and distribution terms for this software are covered by the
// Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
// which can be found in the file epl-v10.html at the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by
// the terms of this license.
// You must not remove this notice, or any other, from this software.

package com.novemberain.langohr.recovery;

import com.novemberain.langohr.Channel;

import java.util.Map;

public abstract class RecordedBinding extends RecordedEntity implements RecoverableEntity {
  protected String source;
  protected String destination;
  protected String routingKey;
  protected Map<String, Object> arguments;

  public RecordedBinding(Channel channel) {
    super(channel);
  }

  public RecordedBinding source(String value) {
    this.source = value;
    return this;
  }

  public RecordedBinding destination(String value) {
    this.destination = value;
    return this;
  }

  public RecordedBinding routingKey(String value) {
    this.routingKey = value;
    return this;
  }

  public RecordedBinding arguments(Map<String, Object> value) {
    this.arguments = value;
    return this;
  }

  public String getSource() {
    return source;
  }

  public String getDestination() {
    return destination;
  }

  public Map<String, Object> getArguments() {
    return arguments;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RecordedBinding that = (RecordedBinding) o;

    if (arguments != null ? !arguments.equals(that.arguments) : that.arguments != null) return false;
    if (!destination.equals(that.destination)) return false;
    if (!routingKey.equals(that.routingKey)) return false;

    return source.equals(that.source);
  }

  @Override
  public int hashCode() {
    int result = source.hashCode();
    result = 31 * result + destination.hashCode();
    result = 31 * result + routingKey.hashCode();
    result = 31 * result + (arguments != null ? arguments.hashCode() : 0);
    return result;
  }
}
