package com.aiceltech.interview.algorithm;

public interface Container<E> {

    /**
     * Returns <tt>true</tt> if this container contains the specified element. More
     * formally, returns <tt>true</tt> if and only if this container contains at
     * least one element <tt>e</tt> such that <tt>(o.equals(e))</tt>.
     *
     * @param e element whose presence in this container is to be tested
     * @return <tt>true</tt> if this container contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    boolean contains(E e);

    /**
     * Returns the number of instances of the specified element present in this
     * container. More formally, returns the number of elements such that
     * <tt>(o.equals(e))</tt>.
     *
     * @param e element whose number of instances is to be counted
     * @return the number of instances of the specified element in this container
     * @throws NullPointerException if the specified element is null
     */
    int getCount(E e);

    /**
     * Adds the specified element to this container.
     *
     * @param e element to be added to this container
     * @throws NullPointerException if the specified element is null
     */
    void add(E e);

    /**
     * Removes a single instance of the specified element from this container.
     * More formally, removes an element <tt>e</tt> such that <tt>o.equals(e)</tt>,
     * if this collection contains one or more such elements.
     * Returns <tt>true</tt> is this container contained the specified element.
     *
     * @param e element to be removed from this container
     * @return <tt>true</tt> is an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null
     */
    boolean remove(E e);
}
