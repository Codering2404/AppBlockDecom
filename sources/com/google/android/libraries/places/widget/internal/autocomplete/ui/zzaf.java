package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.internal.zznb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaf extends DefaultItemAnimator {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f79031t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final List f79032u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final List f79033v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f79034w;

    public zzaf(Resources resources) {
        this.f79034w = resources.getDimensionPixelSize(R.dimen.f74684j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final void c0() {
        if (p()) {
            return;
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g0(View view) {
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }

    final /* synthetic */ List e0() {
        return this.f79033v;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void j(RecyclerView.ViewHolder viewHolder) throws Throwable {
        try {
            super.j(viewHolder);
            if (this.f79031t.remove(viewHolder)) {
                g0(viewHolder.itemView);
                B(viewHolder);
            }
            c0();
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void k() throws Throwable {
        try {
            List list = this.f79031t;
            int size = list.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) list.get(size);
                g0(viewHolder.itemView);
                B(viewHolder);
                list.remove(size);
            }
            List list2 = this.f79033v;
            int size2 = list2.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    super.k();
                    return;
                }
                ((RecyclerView.ViewHolder) list2.get(size2)).itemView.animate().cancel();
            }
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean p() {
        try {
            if (!super.p() && this.f79032u.isEmpty() && this.f79031t.isEmpty()) {
                return !this.f79033v.isEmpty();
            }
            return true;
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void v() throws Throwable {
        try {
            List list = this.f79032u;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                super.x((RecyclerView.ViewHolder) it.next());
            }
            list.clear();
            super.v();
            List list2 = this.f79031t;
            if (list2.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(list2);
            list2.clear();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) obj;
                View view = viewHolder.itemView;
                this.f79033v.add(viewHolder);
                long jN = n() + (((long) viewHolder.getLayoutPosition()) * 67);
                view.setTranslationY(-this.f79034w);
                view.setAlpha(0.0f);
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                viewPropertyAnimatorAnimate.cancel();
                viewPropertyAnimatorAnimate.translationY(0.0f).alpha(1.0f).setDuration(133L).setInterpolator(new FastOutSlowInInterpolator()).setStartDelay(jN);
                viewPropertyAnimatorAnimate.setListener(new zzae(this, view, viewHolder, viewPropertyAnimatorAnimate)).start();
            }
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean x(RecyclerView.ViewHolder viewHolder) throws Throwable {
        try {
            j(viewHolder);
            viewHolder.itemView.setAlpha(0.0f);
            if (viewHolder instanceof zzak) {
                if (((zzak) viewHolder).c()) {
                    this.f79031t.add(viewHolder);
                    return true;
                }
                this.f79032u.add(viewHolder);
                return true;
            }
            if (((zzq) viewHolder).c()) {
                this.f79031t.add(viewHolder);
                return true;
            }
            this.f79032u.add(viewHolder);
            return true;
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }
}
