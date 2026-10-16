package androidx.media;

import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VolumeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f40473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f40474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f40475c;

    /* JADX INFO: renamed from: androidx.media.VolumeProviderCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements VolumeProviderCompatApi21.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VolumeProviderCompat f40476a;

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void a(int i3) {
            this.f40476a.e(i3);
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void b(int i3) {
            this.f40476a.d(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public final int a() {
        return this.f40475c;
    }

    public final int b() {
        return this.f40474b;
    }

    public final int c() {
        return this.f40473a;
    }

    public void d(int i3) {
    }

    public void e(int i3) {
    }
}
