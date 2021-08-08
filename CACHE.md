MODEL :
------
```
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {

private Long id;
private String name;
private String email;
}
```

SERVICE :
--------
```
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

private static final Cache<Long, Test> testCache = CacheBuilder.newBuilder().initialCapacity(10)
.expireAfterAccess(10, TimeUnit.MINUTES).build();

public Test doTest() {
    Test cache = testCache.getIfPresent(1L);
    if (cache != null) {
      return cache;
    }
    cache = new Test(1l, "test", "test");
    testCache.put(1L, cache);
    return cache;
}
```
