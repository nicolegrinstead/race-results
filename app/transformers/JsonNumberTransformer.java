package transformers;

import flexjson.transformer.AbstractTransformer;

public class JsonNumberTransformer extends AbstractTransformer {
    public void transform(Object object) {
    	getContext().writeOpenObject();
    	getContext().writeName("v");
        getContext().write(String.valueOf(object));
        getContext().writeCloseObject();
    }
    
    @Override
    public Boolean isInline() {
    	return Boolean.TRUE;
    }
}
    