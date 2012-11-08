package transformers;

import flexjson.transformer.AbstractTransformer;

public class JsonTimeTransformer extends AbstractTransformer {
    public void transform(Object object) {
    	getContext().writeName("t");
        getContext().writeQuoted((String) object);
    }
    
    @Override
    public Boolean isInline() {
    	return Boolean.TRUE;
    }
}
    