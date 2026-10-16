package kotlin.coroutines;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class CombinedContext implements CoroutineContext, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f139882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext.Element f139883b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Serialized implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f139884b = new Companion(null);
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoroutineContext[] f139885a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Serialized(CoroutineContext[] elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.f139885a = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.f139885a;
            CoroutineContext coroutineContextPlus = EmptyCoroutineContext.f139889a;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    public CombinedContext(CoroutineContext left, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.f139882a = left;
        this.f139883b = element;
    }

    private final boolean g(CoroutineContext.Element element) {
        return Intrinsics.areEqual(get(element.getKey()), element);
    }

    private final boolean h(CombinedContext combinedContext) {
        while (g(combinedContext.f139883b)) {
            CoroutineContext coroutineContext = combinedContext.f139882a;
            if (!(coroutineContext instanceof CombinedContext)) {
                Intrinsics.checkNotNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return g((CoroutineContext.Element) coroutineContext);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
        return false;
    }

    private final int i() {
        int i3 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.f139882a;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i3;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m(String acc, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        Intrinsics.checkNotNullParameter(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef, Unit unit, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(unit, "<unused var>");
        Intrinsics.checkNotNullParameter(element, "element");
        int i3 = intRef.f140142a;
        intRef.f140142a = i3 + 1;
        coroutineContextArr[i3] = element;
        return Unit.f139807a;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        int i3 = i();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[i3];
        final Ref.IntRef intRef = new Ref.IntRef();
        fold(Unit.f139807a, new Function2() { // from class: kotlin.coroutines.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.n(coroutineContextArr, intRef, (Unit) obj, (CoroutineContext.Element) obj2);
            }
        });
        if (intRef.f140142a == i3) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CombinedContext)) {
            return false;
        }
        CombinedContext combinedContext = (CombinedContext) obj;
        return combinedContext.i() == i() && combinedContext.h(this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(this.f139882a.fold(obj, operation), this.f139883b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext.Element element = combinedContext.f139883b.get(key);
            if (element != null) {
                return element;
            }
            CoroutineContext coroutineContext = combinedContext.f139882a;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.f139882a.hashCode() + this.f139883b.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.f139883b.get(key) != null) {
            return this.f139882a;
        }
        CoroutineContext coroutineContextMinusKey = this.f139882a.minusKey(key);
        return coroutineContextMinusKey == this.f139882a ? this : coroutineContextMinusKey == EmptyCoroutineContext.f139889a ? this.f139883b : new CombinedContext(coroutineContextMinusKey, this.f139883b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public /* bridge */ CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.b(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold("", new Function2() { // from class: kotlin.coroutines.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.m((String) obj, (CoroutineContext.Element) obj2);
            }
        })) + ']';
    }
}
