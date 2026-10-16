package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CheckableGroup<T extends MaterialCheckable<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f81122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f81123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnCheckedStateChangeListener f81124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f81125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f81126e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCheckedStateChangeListener {
        void a(Set set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(MaterialCheckable materialCheckable) {
        int id = materialCheckable.getId();
        if (this.f81123b.contains(Integer.valueOf(id))) {
            return false;
        }
        MaterialCheckable materialCheckable2 = (MaterialCheckable) this.f81122a.get(Integer.valueOf(k()));
        if (materialCheckable2 != null) {
            q(materialCheckable2, false);
        }
        boolean zAdd = this.f81123b.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return zAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        OnCheckedStateChangeListener onCheckedStateChangeListener = this.f81124c;
        if (onCheckedStateChangeListener != null) {
            onCheckedStateChangeListener.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(MaterialCheckable materialCheckable, boolean z2) {
        int id = materialCheckable.getId();
        if (!this.f81123b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z2 && this.f81123b.size() == 1 && this.f81123b.contains(Integer.valueOf(id))) {
            materialCheckable.setChecked(true);
            return false;
        }
        boolean zRemove = this.f81123b.remove(Integer.valueOf(id));
        if (materialCheckable.isChecked()) {
            materialCheckable.setChecked(false);
        }
        return zRemove;
    }

    public void e(MaterialCheckable materialCheckable) {
        this.f81122a.put(Integer.valueOf(materialCheckable.getId()), materialCheckable);
        if (materialCheckable.isChecked()) {
            g(materialCheckable);
        }
        materialCheckable.setInternalOnCheckedChangeListener(new MaterialCheckable.OnCheckedChangeListener<T>() { // from class: com.google.android.material.internal.CheckableGroup.1
            @Override // com.google.android.material.internal.MaterialCheckable.OnCheckedChangeListener
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MaterialCheckable materialCheckable2, boolean z2) {
                if (!z2) {
                    CheckableGroup checkableGroup = CheckableGroup.this;
                    if (!checkableGroup.q(materialCheckable2, checkableGroup.f81126e)) {
                        return;
                    }
                } else if (!CheckableGroup.this.g(materialCheckable2)) {
                    return;
                }
                CheckableGroup.this.m();
            }
        });
    }

    public void f(int i3) {
        MaterialCheckable materialCheckable = (MaterialCheckable) this.f81122a.get(Integer.valueOf(i3));
        if (materialCheckable != null && g(materialCheckable)) {
            m();
        }
    }

    public void h() {
        boolean zIsEmpty = this.f81123b.isEmpty();
        Iterator it = this.f81122a.values().iterator();
        while (it.hasNext()) {
            q((MaterialCheckable) it.next(), false);
        }
        if (zIsEmpty) {
            return;
        }
        m();
    }

    public Set i() {
        return new HashSet(this.f81123b);
    }

    public List j(ViewGroup viewGroup) {
        Set setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof MaterialCheckable) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.f81125d || this.f81123b.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f81123b.iterator().next()).intValue();
    }

    public boolean l() {
        return this.f81125d;
    }

    public void n(MaterialCheckable materialCheckable) {
        materialCheckable.setInternalOnCheckedChangeListener(null);
        this.f81122a.remove(Integer.valueOf(materialCheckable.getId()));
        this.f81123b.remove(Integer.valueOf(materialCheckable.getId()));
    }

    public void o(boolean z2) {
        this.f81126e = z2;
    }

    public void p(boolean z2) {
        if (this.f81125d != z2) {
            this.f81125d = z2;
            h();
        }
    }
}
