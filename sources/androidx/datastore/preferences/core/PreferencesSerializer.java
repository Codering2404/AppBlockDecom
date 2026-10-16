package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PreferencesSerializer implements OkioSerializer<Preferences> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreferencesSerializer f35957a = new PreferencesSerializer();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35958a;

        static {
            int[] iArr = new int[PreferencesProto.Value.ValueCase.values().length];
            try {
                iArr[PreferencesProto.Value.ValueCase.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f35958a = iArr;
        }
    }

    private PreferencesSerializer() {
    }

    private final void c(String str, PreferencesProto.Value value, MutablePreferences mutablePreferences) throws CorruptionException {
        PreferencesProto.Value.ValueCase valueCaseO0 = value.o0();
        switch (valueCaseO0 == null ? -1 : WhenMappings.f35958a[valueCaseO0.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                mutablePreferences.k(PreferencesKeys.a(str), Boolean.valueOf(value.f0()));
                return;
            case 2:
                mutablePreferences.k(PreferencesKeys.d(str), Float.valueOf(value.j0()));
                return;
            case 3:
                mutablePreferences.k(PreferencesKeys.c(str), Double.valueOf(value.i0()));
                return;
            case 4:
                mutablePreferences.k(PreferencesKeys.e(str), Integer.valueOf(value.k0()));
                return;
            case 5:
                mutablePreferences.k(PreferencesKeys.f(str), Long.valueOf(value.l0()));
                return;
            case 6:
                Preferences.Key keyG = PreferencesKeys.g(str);
                String strM0 = value.m0();
                Intrinsics.checkNotNullExpressionValue(strM0, "value.string");
                mutablePreferences.k(keyG, strM0);
                return;
            case 7:
                Preferences.Key keyH = PreferencesKeys.h(str);
                List listB0 = value.n0().b0();
                Intrinsics.checkNotNullExpressionValue(listB0, "value.stringSet.stringsList");
                mutablePreferences.k(keyH, CollectionsKt.toSet(listB0));
                return;
            case 8:
                Preferences.Key keyB = PreferencesKeys.b(str);
                byte[] bArrI = value.g0().I();
                Intrinsics.checkNotNullExpressionValue(bArrI, "value.bytes.toByteArray()");
                mutablePreferences.k(keyB, bArrI);
                return;
            case 9:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final PreferencesProto.Value e(Object obj) {
        if (obj instanceof Boolean) {
            GeneratedMessageLite generatedMessageLiteBuild = PreferencesProto.Value.p0().K(((Boolean) obj).booleanValue()).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild, "newBuilder().setBoolean(value).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild;
        }
        if (obj instanceof Float) {
            GeneratedMessageLite generatedMessageLiteBuild2 = PreferencesProto.Value.p0().N(((Number) obj).floatValue()).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild2, "newBuilder().setFloat(value).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild2;
        }
        if (obj instanceof Double) {
            GeneratedMessageLite generatedMessageLiteBuild3 = PreferencesProto.Value.p0().M(((Number) obj).doubleValue()).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild3, "newBuilder().setDouble(value).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild3;
        }
        if (obj instanceof Integer) {
            GeneratedMessageLite generatedMessageLiteBuild4 = PreferencesProto.Value.p0().O(((Number) obj).intValue()).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild4, "newBuilder().setInteger(value).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild4;
        }
        if (obj instanceof Long) {
            GeneratedMessageLite generatedMessageLiteBuild5 = PreferencesProto.Value.p0().P(((Number) obj).longValue()).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild5, "newBuilder().setLong(value).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild5;
        }
        if (obj instanceof String) {
            GeneratedMessageLite generatedMessageLiteBuild6 = PreferencesProto.Value.p0().Q((String) obj).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild6, "newBuilder().setString(value).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild6;
        }
        if (obj instanceof Set) {
            PreferencesProto.Value.Builder builderP0 = PreferencesProto.Value.p0();
            PreferencesProto.StringSet.Builder builderC0 = PreferencesProto.StringSet.c0();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            GeneratedMessageLite generatedMessageLiteBuild7 = builderP0.R(builderC0.K((Set) obj)).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild7, "newBuilder()\n           …                 .build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild7;
        }
        if (obj instanceof byte[]) {
            GeneratedMessageLite generatedMessageLiteBuild8 = PreferencesProto.Value.p0().L(ByteString.p((byte[]) obj)).build();
            Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild8, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return (PreferencesProto.Value) generatedMessageLiteBuild8;
        }
        throw new IllegalStateException("PreferencesSerializer does not support type: " + obj.getClass().getName());
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object a(BufferedSource bufferedSource, Continuation continuation) throws CorruptionException {
        PreferencesProto.PreferenceMap preferenceMapA = PreferencesMapCompat.f35917a.a(bufferedSource.H2());
        MutablePreferences mutablePreferencesB = PreferencesFactory.b(new Preferences.Pair[0]);
        Map mapZ = preferenceMapA.Z();
        Intrinsics.checkNotNullExpressionValue(mapZ, "preferencesProto.preferencesMap");
        for (Map.Entry entry : mapZ.entrySet()) {
            String name = (String) entry.getKey();
            PreferencesProto.Value value = (PreferencesProto.Value) entry.getValue();
            PreferencesSerializer preferencesSerializer = f35957a;
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            preferencesSerializer.c(name, value, mutablePreferencesB);
        }
        return mutablePreferencesB.e();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Preferences getDefaultValue() {
        return PreferencesFactory.a();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object b(Preferences preferences, BufferedSink bufferedSink, Continuation continuation) {
        Map mapA = preferences.a();
        PreferencesProto.PreferenceMap.Builder builderC0 = PreferencesProto.PreferenceMap.c0();
        for (Map.Entry entry : mapA.entrySet()) {
            builderC0.K(((Preferences.Key) entry.getKey()).a(), e(entry.getValue()));
        }
        ((PreferencesProto.PreferenceMap) builderC0.build()).p(bufferedSink.D2());
        return Unit.f139807a;
    }
}
