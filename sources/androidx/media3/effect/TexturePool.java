package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import com.google.common.collect.Iterables;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TexturePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f42642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue f42643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f42644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f42645d;

    public TexturePool(boolean z2, int i3) {
        this.f42644c = i3;
        this.f42645d = z2;
        this.f42642a = new ArrayDeque(i3);
        this.f42643b = new ArrayDeque(i3);
    }

    private void b(GlObjectsProvider glObjectsProvider, int i3, int i4) {
        Assertions.g(this.f42642a.isEmpty());
        Assertions.g(this.f42643b.isEmpty());
        for (int i5 = 0; i5 < this.f42644c; i5++) {
            this.f42642a.add(glObjectsProvider.b(GlUtil.u(i3, i4, this.f42645d), i3, i4));
        }
    }

    private Iterator i() {
        return Iterables.d(this.f42642a, this.f42643b).iterator();
    }

    public int a() {
        return this.f42644c;
    }

    public void c() {
        Iterator itI = i();
        while (itI.hasNext()) {
            ((GlTextureInfo) itI.next()).a();
        }
        this.f42642a.clear();
        this.f42643b.clear();
    }

    public void d(GlObjectsProvider glObjectsProvider, int i3, int i4) {
        if (!j()) {
            b(glObjectsProvider, i3, i4);
            return;
        }
        GlTextureInfo glTextureInfo = (GlTextureInfo) i().next();
        if (glTextureInfo.f40693d == i3 && glTextureInfo.f40694e == i4) {
            return;
        }
        c();
        b(glObjectsProvider, i3, i4);
    }

    public void e() {
        this.f42642a.addAll(this.f42643b);
        this.f42643b.clear();
    }

    public void f() {
        Assertions.g(!this.f42643b.isEmpty());
        this.f42642a.add((GlTextureInfo) this.f42643b.remove());
    }

    public void g(GlTextureInfo glTextureInfo) {
        Assertions.g(this.f42643b.contains(glTextureInfo));
        this.f42643b.remove(glTextureInfo);
        this.f42642a.add(glTextureInfo);
    }

    public int h() {
        return !j() ? this.f42644c : this.f42642a.size();
    }

    public boolean j() {
        return i().hasNext();
    }

    public boolean k(GlTextureInfo glTextureInfo) {
        return this.f42643b.contains(glTextureInfo);
    }

    public GlTextureInfo l() {
        if (this.f42642a.isEmpty()) {
            throw new IllegalStateException("Textures are all in use. Please release in-use textures before calling useTexture.");
        }
        GlTextureInfo glTextureInfo = (GlTextureInfo) this.f42642a.remove();
        this.f42643b.add(glTextureInfo);
        return glTextureInfo;
    }
}
