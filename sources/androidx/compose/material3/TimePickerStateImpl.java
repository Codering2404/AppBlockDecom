package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TimePickerStateImpl implements TimePickerState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f21382f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f21383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f21384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f21385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableIntState f21386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableIntState f21387e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public TimePickerStateImpl(int i3, int i4, boolean z2) {
        if (i3 < 0 || i3 >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range");
        }
        if (i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range");
        }
        this.f21383a = z2;
        this.f21384b = SnapshotStateKt__SnapshotStateKt.e(TimePickerSelectionMode.c(TimePickerSelectionMode.f21378b.a()), null, 2, null);
        this.f21385c = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(i3 >= 12), null, 2, null);
        this.f21386d = SnapshotIntStateKt.a(i3 % 12);
        this.f21387e = SnapshotIntStateKt.a(i4);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void a(boolean z2) {
        this.f21385c.setValue(Boolean.valueOf(z2));
    }

    @Override // androidx.compose.material3.TimePickerState
    public void b(int i3) {
        this.f21384b.setValue(TimePickerSelectionMode.c(i3));
    }

    @Override // androidx.compose.material3.TimePickerState
    public int c() {
        return ((TimePickerSelectionMode) this.f21384b.getValue()).i();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void d(int i3) {
        a(i3 >= 12);
        this.f21386d.a(i3 % 12);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void e(int i3) {
        this.f21387e.a(i3);
    }

    @Override // androidx.compose.material3.TimePickerState
    public int f() {
        return this.f21387e.g();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean g() {
        return this.f21383a;
    }

    @Override // androidx.compose.material3.TimePickerState
    public int h() {
        return this.f21386d.g() + (i() ? 12 : 0);
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean i() {
        return ((Boolean) this.f21385c.getValue()).booleanValue();
    }
}
