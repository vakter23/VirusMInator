package application.controleur;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import application.modele.tourelles.Tourelles;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class MonObservateurTourelles implements ObservableList<Tourelles>{


	@Override
	public boolean add(Tourelles e) {
		this.add(e);
		return false;
	}

	@Override
	public void add(int index, Tourelles element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends Tourelles> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Tourelles> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		this.clear();
	}

	@Override
	public boolean contains(Object o) {
		if(this.contains(o)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (int i = 0; i < c.size(); i++) {
			if(this.get(i)!=c.) {
				
			}
		}
		return false;
	}

	@Override
	public Tourelles get(int index) {
		return this.get(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if(this.size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public Iterator<Tourelles> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Tourelles> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Tourelles> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tourelles remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tourelles set(int index, Tourelles element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tourelles> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Tourelles... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addListener(ListChangeListener<? super Tourelles> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int from, int to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeAll(Tourelles... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ListChangeListener<? super Tourelles> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean retainAll(Tourelles... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Tourelles... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Collection<? extends Tourelles> col) {
		// TODO Auto-generated method stub
		return false;
	}

}
