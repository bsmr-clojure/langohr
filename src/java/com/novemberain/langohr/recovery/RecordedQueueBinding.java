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

import java.io.IOException;

public class RecordedQueueBinding extends RecordedBinding implements RecoverableEntity {
  public RecordedQueueBinding(Channel channel) {
    super(channel);
  }

  public Object recover() throws IOException {
    return this.channel.getDelegate().queueBind(this.getDestination(), this.getSource(), this.routingKey, this.arguments);
  }
}
