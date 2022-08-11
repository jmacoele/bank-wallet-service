package com.nttdata.bankwalletservice.events;

import java.util.Date;
import lombok.Data;

/**
 * Event Class.
 *
 * @author jmacoele
 *
 * @param <T> data parameter.
 */

@Data
public abstract class Event<T> {
  private String id;
  private Date date;
  private EventType type;
  private T data;
}
