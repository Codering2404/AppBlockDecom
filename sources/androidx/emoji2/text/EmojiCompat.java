package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.google.android.gms.common.api.Api;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class EmojiCompat {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f36844o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Object f36845p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile EmojiCompat f36846q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f36848b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CompatInternal f36851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final MetadataRepoLoader f36852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SpanFactory f36853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f36854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f36855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int[] f36856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f36857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f36858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f36859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final GlyphChecker f36860n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f36847a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f36849c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f36850d = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class CompatInternal19 extends CompatInternal {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile EmojiProcessor f36862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile MetadataRepo f36863c;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        int a(CharSequence charSequence, int i3) {
            return this.f36862b.b(charSequence, i3);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        int b(CharSequence charSequence, int i3) {
            return this.f36862b.c(charSequence, i3);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void c() {
            try {
                this.f36861a.f36852f.a(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void a(Throwable th) {
                        CompatInternal19.this.f36861a.p(th);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void b(MetadataRepo metadataRepo) {
                        CompatInternal19.this.f(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f36861a.p(th);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence d(CharSequence charSequence, int i3, int i4, int i5, boolean z2) {
            return this.f36862b.j(charSequence, i3, i4, i5, z2);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void e(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f36863c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f36861a.f36854h);
        }

        void f(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f36861a.p(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f36863c = metadataRepo;
            MetadataRepo metadataRepo2 = this.f36863c;
            SpanFactory spanFactory = this.f36861a.f36853g;
            GlyphChecker glyphChecker = this.f36861a.f36860n;
            EmojiCompat emojiCompat = this.f36861a;
            this.f36862b = new EmojiProcessor(metadataRepo2, spanFactory, glyphChecker, emojiCompat.f36855i, emojiCompat.f36856j, EmojiExclusions.a());
            this.f36861a.q();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MetadataRepoLoader f36865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SpanFactory f36866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f36867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f36868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f36869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Set f36870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f36871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f36872h = -16711936;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f36873i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        GlyphChecker f36874j = new DefaultGlyphChecker();

        protected Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.i(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f36865a = metadataRepoLoader;
        }

        protected final MetadataRepoLoader a() {
            return this.f36865a;
        }

        public Config b(int i3) {
            this.f36873i = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class DefaultSpanFactory implements SpanFactory {
        @Override // androidx.emoji2.text.EmojiCompat.SpanFactory
        public EmojiSpan a(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            return new TypefaceEmojiSpan(typefaceEmojiRasterizer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface GlyphChecker {
        boolean a(CharSequence charSequence, int i3, int i4, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class ListenerDispatcher implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f36875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f36876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f36877c;

        ListenerDispatcher(InitCallback initCallback, int i3) {
            this(Arrays.asList((InitCallback) Preconditions.i(initCallback, "initCallback cannot be null")), i3, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f36875a.size();
            int i3 = 0;
            if (this.f36877c != 1) {
                while (i3 < size) {
                    ((InitCallback) this.f36875a.get(i3)).a(this.f36876b);
                    i3++;
                }
            } else {
                while (i3 < size) {
                    ((InitCallback) this.f36875a.get(i3)).b();
                    i3++;
                }
            }
        }

        ListenerDispatcher(Collection collection, int i3) {
            this(collection, i3, null);
        }

        ListenerDispatcher(Collection collection, int i3, Throwable th) {
            Preconditions.i(collection, "initCallbacks cannot be null");
            this.f36875a = new ArrayList(collection);
            this.f36877c = i3;
            this.f36876b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface MetadataRepoLoader {
        void a(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(Throwable th);

        public abstract void b(MetadataRepo metadataRepo);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface SpanFactory {
        EmojiSpan a(TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    private EmojiCompat(Config config) {
        this.f36854h = config.f36867c;
        this.f36855i = config.f36868d;
        this.f36856j = config.f36869e;
        this.f36857k = config.f36871g;
        this.f36858l = config.f36872h;
        this.f36852f = config.f36865a;
        this.f36859m = config.f36873i;
        this.f36860n = config.f36874j;
        ArraySet arraySet = new ArraySet();
        this.f36848b = arraySet;
        SpanFactory spanFactory = config.f36866b;
        this.f36853g = spanFactory == null ? new DefaultSpanFactory() : spanFactory;
        Set set = config.f36870f;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.f36870f);
        }
        this.f36851e = new CompatInternal19(this);
        o();
    }

    public static EmojiCompat c() {
        EmojiCompat emojiCompat;
        synchronized (f36844o) {
            emojiCompat = f36846q;
            Preconditions.j(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean h(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z2) {
        return EmojiProcessor.d(inputConnection, editable, i3, i4, z2);
    }

    public static boolean i(Editable editable, int i3, KeyEvent keyEvent) {
        return EmojiProcessor.e(editable, i3, keyEvent);
    }

    public static EmojiCompat j(Config config) {
        EmojiCompat emojiCompat;
        EmojiCompat emojiCompat2 = f36846q;
        if (emojiCompat2 != null) {
            return emojiCompat2;
        }
        synchronized (f36844o) {
            try {
                emojiCompat = f36846q;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    f36846q = emojiCompat;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    public static boolean k() {
        return f36846q != null;
    }

    private boolean m() {
        return g() == 1;
    }

    private void o() {
        this.f36847a.writeLock().lock();
        try {
            if (this.f36859m == 0) {
                this.f36849c = 0;
            }
            this.f36847a.writeLock().unlock();
            if (g() == 0) {
                this.f36851e.c();
            }
        } catch (Throwable th) {
            this.f36847a.writeLock().unlock();
            throw th;
        }
    }

    public int d(CharSequence charSequence, int i3) {
        Preconditions.j(m(), "Not initialized yet");
        Preconditions.i(charSequence, "charSequence cannot be null");
        return this.f36851e.a(charSequence, i3);
    }

    public int e() {
        return this.f36858l;
    }

    public int g() {
        this.f36847a.readLock().lock();
        try {
            return this.f36849c;
        } finally {
            this.f36847a.readLock().unlock();
        }
    }

    public boolean l() {
        return this.f36857k;
    }

    public void n() {
        Preconditions.j(this.f36859m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (m()) {
            return;
        }
        this.f36847a.writeLock().lock();
        try {
            if (this.f36849c == 0) {
                return;
            }
            this.f36849c = 0;
            this.f36847a.writeLock().unlock();
            this.f36851e.c();
        } finally {
            this.f36847a.writeLock().unlock();
        }
    }

    void p(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f36847a.writeLock().lock();
        try {
            this.f36849c = 2;
            arrayList.addAll(this.f36848b);
            this.f36848b.clear();
            this.f36847a.writeLock().unlock();
            this.f36850d.post(new ListenerDispatcher(arrayList, this.f36849c, th));
        } catch (Throwable th2) {
            this.f36847a.writeLock().unlock();
            throw th2;
        }
    }

    void q() {
        ArrayList arrayList = new ArrayList();
        this.f36847a.writeLock().lock();
        try {
            this.f36849c = 1;
            arrayList.addAll(this.f36848b);
            this.f36848b.clear();
            this.f36847a.writeLock().unlock();
            this.f36850d.post(new ListenerDispatcher(arrayList, this.f36849c));
        } catch (Throwable th) {
            this.f36847a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence r(CharSequence charSequence) {
        return s(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence s(CharSequence charSequence, int i3, int i4) {
        return t(charSequence, i3, i4, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public CharSequence t(CharSequence charSequence, int i3, int i4, int i5) {
        return u(charSequence, i3, i4, i5, 0);
    }

    public CharSequence u(CharSequence charSequence, int i3, int i4, int i5, int i6) {
        boolean z2;
        Preconditions.j(m(), "Not initialized yet");
        Preconditions.f(i3, "start cannot be negative");
        Preconditions.f(i4, "end cannot be negative");
        Preconditions.f(i5, "maxEmojiCount cannot be negative");
        Preconditions.b(i3 <= i4, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.b(i3 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.b(i4 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i3 == i4) {
            return charSequence;
        }
        if (i6 != 1) {
            z2 = i6 != 2 ? this.f36854h : false;
        } else {
            z2 = true;
        }
        return this.f36851e.d(charSequence, i3, i4, i5, z2);
    }

    public void v(InitCallback initCallback) {
        Preconditions.i(initCallback, "initCallback cannot be null");
        this.f36847a.writeLock().lock();
        try {
            if (this.f36849c == 1 || this.f36849c == 2) {
                this.f36850d.post(new ListenerDispatcher(initCallback, this.f36849c));
            } else {
                this.f36848b.add(initCallback);
            }
            this.f36847a.writeLock().unlock();
        } catch (Throwable th) {
            this.f36847a.writeLock().unlock();
            throw th;
        }
    }

    public void w(InitCallback initCallback) {
        Preconditions.i(initCallback, "initCallback cannot be null");
        this.f36847a.writeLock().lock();
        try {
            this.f36848b.remove(initCallback);
        } finally {
            this.f36847a.writeLock().unlock();
        }
    }

    public void x(EditorInfo editorInfo) {
        if (!m() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f36851e.e(editorInfo);
    }

    public int f(CharSequence charSequence, int i3) {
        Preconditions.j(m(), "Not initialized yet");
        Preconditions.i(charSequence, jlWo.QGcqsd);
        return this.f36851e.b(charSequence, i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class InitCallback {
        public void b() {
        }

        public void a(Throwable th) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class CompatInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EmojiCompat f36861a;

        CompatInternal(EmojiCompat emojiCompat) {
            this.f36861a = emojiCompat;
        }

        int a(CharSequence charSequence, int i3) {
            return -1;
        }

        int b(CharSequence charSequence, int i3) {
            return -1;
        }

        void c() {
            this.f36861a.q();
        }

        void e(EditorInfo editorInfo) {
        }

        CharSequence d(CharSequence charSequence, int i3, int i4, int i5, boolean z2) {
            return charSequence;
        }
    }
}
