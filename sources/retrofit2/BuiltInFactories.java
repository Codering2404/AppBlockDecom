package retrofit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class BuiltInFactories {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Java8 extends BuiltInFactories {
        Java8() {
        }

        @Override // retrofit2.BuiltInFactories
        List a(Executor executor) {
            return Arrays.asList(new CompletableFutureCallAdapterFactory(), new DefaultCallAdapterFactory(executor));
        }

        @Override // retrofit2.BuiltInFactories
        List b() {
            return Collections.singletonList(new OptionalConverterFactory());
        }
    }

    BuiltInFactories() {
    }

    List a(Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    List b() {
        return Collections.EMPTY_LIST;
    }
}
