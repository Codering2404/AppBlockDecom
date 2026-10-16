package org.koin.core.parameter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.error.NoParameterFoundException;
import org.koin.core.module.KoinDslMarker;
import org.koin.ext.KClassExtKt;

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
@KoinDslMarker
@Metadata
public class ParametersHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f146045b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f146046a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ParametersHolder(List _values) {
        Intrinsics.checkNotNullParameter(_values, "_values");
        this.f146046a = _values;
    }

    public final ParametersHolder a(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f146046a.add(value);
        return this;
    }

    public Object b(int i3, KClass clazz) throws NoParameterFoundException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.f146046a.size() > i3) {
            return this.f146046a.get(i3);
        }
        throw new NoParameterFoundException("Can't get injected parameter #" + i3 + " from " + this + " for type '" + KClassExtKt.a(clazz) + '\'');
    }

    public Object c(KClass clazz) {
        Object obj;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Iterator it = this.f146046a.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (clazz.e(next) && next != null) {
                obj = next;
            }
        } while (obj == null);
        return obj;
    }

    public final List d() {
        return this.f146046a;
    }

    public String toString() {
        return "DefinitionParameters" + CollectionsKt.toList(this.f146046a);
    }

    public /* synthetic */ ParametersHolder(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }
}
