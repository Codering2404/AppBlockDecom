package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.modules.ContextualProvider;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SerializersModuleBuilder implements SerializersModuleCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f143199a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f143200b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f143201c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f143202d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f143203e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f143204f;

    public static /* synthetic */ void k(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, KClass kClass2, KSerializer kSerializer, boolean z2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        serializersModuleBuilder.j(kClass, kClass2, kSerializer, z2);
    }

    public static /* synthetic */ void m(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, ContextualProvider contextualProvider, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        serializersModuleBuilder.l(kClass, contextualProvider, z2);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void a(KClass baseClass, KClass actualClass, KSerializer actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        k(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void b(KClass baseClass, Function1 defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        h(baseClass, defaultDeserializerProvider, false);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void c(KClass kClass, KSerializer serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        m(this, kClass, new ContextualProvider.Argless(serializer), false, 4, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void d(KClass baseClass, Function1 defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        i(baseClass, defaultSerializerProvider, false);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void e(KClass kClass, Function1 provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        m(this, kClass, new ContextualProvider.WithTypeArguments(provider), false, 4, null);
    }

    public final SerializersModule f() {
        return new SerialModuleImpl(this.f143199a, this.f143200b, this.f143201c, this.f143202d, this.f143203e, this.f143204f);
    }

    public final void g(SerializersModule module) {
        Intrinsics.checkNotNullParameter(module, "module");
        module.a(this);
    }

    public final void h(KClass baseClass, Function1 defaultDeserializerProvider, boolean z2) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        Function1 function1 = (Function1) this.f143203e.get(baseClass);
        if (function1 == null || Intrinsics.areEqual(function1, defaultDeserializerProvider) || z2) {
            this.f143203e.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + function1);
    }

    public final void i(KClass baseClass, Function1 defaultSerializerProvider, boolean z2) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        Function1 function1 = (Function1) this.f143201c.get(baseClass);
        if (function1 == null || Intrinsics.areEqual(function1, defaultSerializerProvider) || z2) {
            this.f143201c.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + function1);
    }

    public final void j(KClass baseClass, KClass concreteClass, KSerializer concreteSerializer, boolean z2) {
        Object next;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(concreteClass, "concreteClass");
        Intrinsics.checkNotNullParameter(concreteSerializer, "concreteSerializer");
        String strI = concreteSerializer.getDescriptor().i();
        Map map = this.f143200b;
        Object map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(baseClass, map2);
        }
        Map map3 = (Map) map2;
        KSerializer kSerializer = (KSerializer) map3.get(concreteClass);
        Map map4 = this.f143202d;
        Object map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(baseClass, map5);
        }
        Map map6 = (Map) map5;
        if (z2) {
            if (kSerializer != null) {
                map6.remove(kSerializer.getDescriptor().i());
            }
            map3.put(concreteClass, concreteSerializer);
            map6.put(strI, concreteSerializer);
            return;
        }
        if (kSerializer != null) {
            if (!Intrinsics.areEqual(kSerializer, concreteSerializer)) {
                throw new SerializerAlreadyRegisteredException(baseClass, concreteClass);
            }
        }
        KSerializer kSerializer2 = (KSerializer) map6.get(strI);
        if (kSerializer2 == null) {
            map3.put(concreteClass, concreteSerializer);
            map6.put(strI, concreteSerializer);
            return;
        }
        Object obj = this.f143200b.get(baseClass);
        Intrinsics.checkNotNull(obj);
        Iterator it = MapsKt.asSequence((Map) obj).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Map.Entry) next).getValue() == kSerializer2) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + strI + "': '" + concreteClass + "' and '" + ((Map.Entry) next) + '\'');
    }

    public final void l(KClass forClass, ContextualProvider provider, boolean z2) {
        ContextualProvider contextualProvider;
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (z2 || (contextualProvider = (ContextualProvider) this.f143199a.get(forClass)) == null || Intrinsics.areEqual(contextualProvider, provider)) {
            this.f143199a.put(forClass, provider);
            if (PlatformKt.l(forClass)) {
                this.f143204f = true;
                return;
            }
            return;
        }
        throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
    }
}
