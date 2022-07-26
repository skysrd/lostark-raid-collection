package skysrd.lostarkraidcollection.exception;

import lombok.Getter;
import skysrd.lostarkraidcollection.result.JsonResultData;

@Getter
public class CustomAuthException extends RuntimeException{
    private JsonResultData errorEntity;

    public CustomAuthException(JsonResultData errorEntity){
        super(errorEntity.getError().getMessage());
        this.errorEntity = errorEntity;
    }
}
