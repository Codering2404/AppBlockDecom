package androidx.glance.appwidget;

import android.content.Context;
import androidx.glance.Emittable;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.state.GlanceState;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class LayoutConfiguration {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f38090g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f38092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f38095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f38096f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LayoutConfiguration a(Context context, int i3) {
            return new LayoutConfiguration(context, new LinkedHashMap(), 0, i3, null, null, 48, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(android.content.Context r10, int r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.LayoutConfiguration.Companion.b(android.content.Context, int, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    private LayoutConfiguration(Context context, Map map, int i3, int i4, Set set, Set set2) {
        this.f38091a = context;
        this.f38092b = map;
        this.f38093c = i3;
        this.f38094d = i4;
        this.f38095e = set;
        this.f38096f = set2;
    }

    public final int c(Emittable emittable) {
        LayoutProto.LayoutNode layoutNodeB = WidgetLayoutKt.b(this.f38091a, emittable);
        synchronized (this) {
            Integer num = (Integer) this.f38092b.get(layoutNodeB);
            if (num != null) {
                int iIntValue = num.intValue();
                this.f38095e.add(Integer.valueOf(iIntValue));
                return iIntValue;
            }
            int iB = this.f38093c;
            while (this.f38096f.contains(Integer.valueOf(iB))) {
                iB = (iB + 1) % LayoutSelectionKt.b();
                if (iB == this.f38093c) {
                    throw new IllegalArgumentException("Cannot assign a valid layout index to the new layout: no free index left.");
                }
            }
            this.f38093c = (iB + 1) % LayoutSelectionKt.b();
            this.f38095e.add(Integer.valueOf(iB));
            this.f38096f.add(Integer.valueOf(iB));
            this.f38092b.put(layoutNodeB, Integer.valueOf(iB));
            return iB;
        }
    }

    public final Object d(Continuation continuation) {
        Object objE = GlanceState.f39700a.e(this.f38091a, LayoutStateDefinition.f38125a, WidgetLayoutKt.f(this.f38094d), new LayoutConfiguration$save$2(this, null), continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    /* synthetic */ LayoutConfiguration(Context context, Map map, int i3, int i4, Set set, Set set2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, map, i3, i4, (i5 & 16) != 0 ? new LinkedHashSet() : set, (i5 & 32) != 0 ? new LinkedHashSet() : set2);
    }
}
