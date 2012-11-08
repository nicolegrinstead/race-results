import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.google.common.collect.ImmutableMap;

import models.Race;
import transformers.JsonNumberTransformer;
import transformers.JsonStringTransformer;
import transformers.JsonTimeTransformer;
import flexjson.JSONSerializer;

public class JsonTest {
	public static void main(String[] args) {
		ImmutableMap<String, List<String>> test = ImmutableMap.of("c", Arrays.asList("value", "value"));
		List<ImmutableMap<String, List<String>>> asList = Arrays.asList(test,test);
		System.out.println(ReflectionToStringBuilder.toString(test));
		JSONSerializer postListSerializer = new JSONSerializer()
				.exclude("class", "entityId", "id", "persistent")
				.prettyPrint(true)
				.rootName("rows");

		System.out.println(postListSerializer.serialize(asList));

		// Race race = Race.findById(1);
		// JSONSerializer postListSerializer = new JSONSerializer()
		// .exclude("class", "entityId", "id", "persistent")
		// .prettyPrint(false)
		// .transform(new JsonStringTransformer(), "name", "division",
		// "homeLocation", "gender")
		// .transform(new JsonTimeTransformer(), "gunTime", "chipTime")
		// .transform(new JsonNumberTransformer(), "age", "bibNumber")
		// .rootName("c");
		// postListSerializer.serialize(race.results);
	}
}
