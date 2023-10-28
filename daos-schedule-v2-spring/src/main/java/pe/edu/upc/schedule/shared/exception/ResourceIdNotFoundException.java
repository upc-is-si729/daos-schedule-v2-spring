package pe.edu.upc.schedule.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceIdNotFoundException extends RuntimeException {

  public ResourceIdNotFoundException(String resourceName, Integer resourceId) {
    super(String.format("%s with id %d not found.", resourceName, resourceId));
    StackTraceElement[] mio = {};
    this.setStackTrace(mio);
  }

}
