package transformers;

import flexjson.transformer.AbstractTransformer;

public class JsonStringTransformer extends AbstractTransformer {
    public void transform(Object object) {
    	getContext().writeName("v");
        getContext().writeQuoted((String) object);
    }
    
    @Override
    public Boolean isInline() {
    	return Boolean.TRUE;
    }
}
    