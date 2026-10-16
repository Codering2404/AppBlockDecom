package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbpy extends zzboh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbpw f76631f = new zzbpr();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzbpw f76632g = new zzbps();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzbpw f76633h = new zzbpt();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzbpw f76634i = new zzbpu();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzbpx f76635j = new zzbpv();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deque f76636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Deque f76637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f76639d;

    public zzbpy() {
        new ArrayDeque(2);
        this.f76636a = new ArrayDeque();
    }

    private final int c(zzbpx zzbpxVar, int i3, Object obj, int i4) {
        a(i3);
        Deque deque = this.f76636a;
        if (!deque.isEmpty()) {
            i();
        }
        while (i3 > 0 && !deque.isEmpty()) {
            zzbxo zzbxoVar = (zzbxo) deque.peek();
            int iMin = Math.min(i3, zzbxoVar.zzf());
            i4 = zzbpxVar.a(zzbxoVar, iMin, obj, i4);
            i3 -= iMin;
            this.f76638c -= iMin;
            i();
        }
        if (i3 <= 0) {
            return i4;
        }
        throw new AssertionError("Failed executing read operation");
    }

    private final int f(zzbpw zzbpwVar, int i3, Object obj, int i4) {
        try {
            return c(zzbpwVar, i3, obj, i4);
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    private final void i() {
        if (((zzbxo) this.f76636a.peek()).zzf() == 0) {
            j();
        }
    }

    private final void j() {
        if (!this.f76639d) {
            ((zzbxo) this.f76636a.remove()).close();
            return;
        }
        Deque deque = this.f76637b;
        Deque deque2 = this.f76636a;
        deque.add((zzbxo) deque2.remove());
        zzbxo zzbxoVar = (zzbxo) deque2.peek();
        if (zzbxoVar != null) {
            zzbxoVar.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void M0(ByteBuffer byteBuffer) {
        f(f76634i, byteBuffer.remaining(), byteBuffer, 0);
    }

    public final void b(zzbxo zzbxoVar) {
        boolean z2 = this.f76639d && this.f76636a.isEmpty();
        if (zzbxoVar instanceof zzbpy) {
            zzbpy zzbpyVar = (zzbpy) zzbxoVar;
            while (true) {
                Deque deque = zzbpyVar.f76636a;
                if (deque.isEmpty()) {
                    break;
                } else {
                    this.f76636a.add((zzbxo) deque.remove());
                }
            }
            this.f76638c += zzbpyVar.f76638c;
            zzbpyVar.f76638c = 0;
            zzbpyVar.close();
        } else {
            this.f76636a.add(zzbxoVar);
            this.f76638c += zzbxoVar.zzf();
        }
        if (z2) {
            ((zzbxo) this.f76636a.peek()).zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        while (true) {
            Deque deque = this.f76636a;
            if (deque.isEmpty()) {
                break;
            } else {
                ((zzbxo) deque.remove()).close();
            }
        }
        if (this.f76637b != null) {
            while (!this.f76637b.isEmpty()) {
                ((zzbxo) this.f76637b.remove()).close();
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void j2(OutputStream outputStream, int i3) {
        c(f76635j, i3, outputStream, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo
    public final boolean zza() {
        Iterator it = this.f76636a.iterator();
        while (it.hasNext()) {
            if (!((zzbxo) it.next()).zza()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo
    public final void zzb() {
        if (this.f76637b == null) {
            this.f76637b = new ArrayDeque(Math.min(this.f76636a.size(), 16));
        }
        while (!this.f76637b.isEmpty()) {
            ((zzbxo) this.f76637b.remove()).close();
        }
        this.f76639d = true;
        zzbxo zzbxoVar = (zzbxo) this.f76636a.peek();
        if (zzbxoVar != null) {
            zzbxoVar.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo
    public final void zzc() {
        if (!this.f76639d) {
            throw new InvalidMarkException();
        }
        Deque deque = this.f76636a;
        zzbxo zzbxoVar = (zzbxo) deque.peek();
        if (zzbxoVar != null) {
            int iZzf = zzbxoVar.zzf();
            zzbxoVar.zzc();
            this.f76638c += zzbxoVar.zzf() - iZzf;
        }
        while (true) {
            zzbxo zzbxoVar2 = (zzbxo) this.f76637b.pollLast();
            if (zzbxoVar2 == null) {
                return;
            }
            zzbxoVar2.zzc();
            deque.addFirst(zzbxoVar2);
            this.f76638c += zzbxoVar2.zzf();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final int zzf() {
        return this.f76638c;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final int zzg() {
        return f(f76631f, 1, null, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void zzh(int i3) {
        f(f76632g, i3, null, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void zzi(byte[] bArr, int i3, int i4) {
        f(f76633h, i4, bArr, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.libraries.places.internal.zzbxo] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.libraries.places.internal.zzbxo] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.libraries.places.internal.zzbpy] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.libraries.places.internal.zzbpy] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.google.android.libraries.places.internal.zzbxo
    public final zzbxo zzl(int i3) {
        zzbxo zzbxoVarZzl;
        int i4;
        zzbxo zzbxoVarZzl2;
        ?? r12;
        ?? r02;
        if (i3 <= 0) {
            return zzbxr.a();
        }
        a(i3);
        this.f76638c -= i3;
        ?? r03 = 0;
        ?? zzbpyVar = 0;
        while (true) {
            Deque deque = this.f76636a;
            zzbxo zzbxoVar = (zzbxo) deque.peek();
            int iZzf = zzbxoVar.zzf();
            if (iZzf > i3) {
                zzbxoVarZzl2 = zzbxoVar.zzl(i3);
                i4 = 0;
            } else {
                if (this.f76639d) {
                    zzbxoVarZzl = zzbxoVar.zzl(iZzf);
                    j();
                } else {
                    zzbxoVarZzl = (zzbxo) deque.poll();
                }
                zzbxo zzbxoVar2 = zzbxoVarZzl;
                i4 = i3 - iZzf;
                zzbxoVarZzl2 = zzbxoVar2;
            }
            if (r03 == 0) {
                r02 = zzbxoVarZzl2;
                r12 = zzbpyVar;
            } else {
                if (zzbpyVar == 0) {
                    zzbpyVar = new zzbpy(i4 != 0 ? Math.min(deque.size() + 2, 16) : 2);
                    zzbpyVar.b(r03);
                    r03 = zzbpyVar;
                }
                zzbpyVar.b(zzbxoVarZzl2);
                r02 = r03;
                r12 = zzbpyVar;
            }
            if (i4 <= 0) {
                return r02;
            }
            i3 = i4;
            r03 = r02;
            zzbpyVar = r12;
        }
    }

    public zzbpy(int i3) {
        new ArrayDeque(2);
        this.f76636a = new ArrayDeque(i3);
    }
}
