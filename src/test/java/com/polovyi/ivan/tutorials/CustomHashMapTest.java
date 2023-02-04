package com.polovyi.ivan.tutorials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CustomHashMapTest {

    @Test
    public void shouldCreateHashMapWithSizeEqualsZero() {
        // given
        CustomHashMap<Integer, String> customHashMap = new CustomHashMapImpl();
        // when
        int size = customHashMap.size();
        // then
        assertEquals(0, size);
    }

    @Test
    public void shouldCreateEmptyHashMap() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        // when
        boolean isEmpty = customHashMap.isEmpty();
        // then
        assertTrue(isEmpty);
    }

    @Test
    public void shouldNotBeEmptyWhenPutMethodCalledOnHashMap() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "ArrayList");
        // when
        boolean isEmpty = customHashMap.isEmpty();
        // then
        assertFalse(isEmpty);
    }

    @Test
    public void shouldPutOneElementToHashMap() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        // when
        customHashMap.put('A', "Array");
        // then
        assertEquals(1, customHashMap.size());
    }

    @Test
    public void shouldRemoveOneElementFromHashMap() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        // when
        customHashMap.put('A', "Array");
        customHashMap.remove('A');
        // then
        assertEquals(0, customHashMap.size());
    }

    @Test
    public void shouldRemoveFirstElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('B', "ArrayList");
        customHashMap.put('Y', "HashMap");
        // when
        customHashMap.remove('A');
        // then
        assertEquals(2, customHashMap.size());
    }

    @Test
    public void shouldRemoveSecondElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('E', "ArrayList");
        customHashMap.put('Y', "HashMap");
        // when
        customHashMap.remove('E');
        // then
        assertEquals(2, customHashMap.size());
    }

    @Test
    public void shouldRemoveLastElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('E', "ArrayList");
        customHashMap.put('Y', "HashMap");
        // when
        customHashMap.remove('Y');
        // then
        assertEquals(2, customHashMap.size());
    }

    @Test
    public void shouldRemoveAllElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('B', "ArrayList");
        customHashMap.put('C', "LinkedList");
        customHashMap.put('D', "HashMap");
        customHashMap.put('E', "HashSet");
        customHashMap.put('Y', "Stack");
        // when
        customHashMap.remove('A');
        customHashMap.remove('B');
        customHashMap.remove('C');
        customHashMap.remove('D');
        customHashMap.remove('E');
        customHashMap.remove('Y');
        // then
        assertEquals(0, customHashMap.size());
    }

    @Test
    public void shouldReturnTrueWhenContainsKeyCalledForFirstElementInBucketGivenBucketWithTwoElement() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "ArrayList");
        customHashMap.put('E', "HashMap");
        // when
        boolean isContainKey = customHashMap.containsKey('A');
        // then
        assertTrue(isContainKey);
    }

    @Test
    public void shouldReturnTrueWhenContainsKeyCalledForLastElementInBucketGivenBucketWithTwoElement() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('B', "ArrayList");
        customHashMap.put('C', "LinkedList");
        customHashMap.put('D', "HashMap");
        customHashMap.put('E', "HashSet");
        customHashMap.put('Y', "Stack");
        // when
        boolean hasAKey = customHashMap.containsKey('A');
        boolean hasBKey = customHashMap.containsKey('B');
        boolean hasCKey = customHashMap.containsKey('C');
        boolean hasDKey = customHashMap.containsKey('D');
        boolean hasEKey = customHashMap.containsKey('E');
        boolean hasYKey = customHashMap.containsKey('Y');
        // then
        assertTrue(hasAKey);
        assertTrue(hasBKey);
        assertTrue(hasCKey);
        assertTrue(hasDKey);
        assertTrue(hasEKey);
        assertTrue(hasYKey);
    }

    @Test
    public void shouldUpdateDuplicateKeyWhenItIsFirstInTheBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();

        customHashMap.put('A', "Array");
        String expectedValue = "ArrayList";
        customHashMap.put('A', expectedValue);
        // when
        String keyA = customHashMap.get('A');
        // then
        assertEquals(expectedValue, keyA);
        assertEquals(1, customHashMap.size());
    }

    @Test
    public void shouldUpdateDuplicateKeyWhenItIsLastInTheBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();

        customHashMap.put('A', "Array");
        customHashMap.put('Y', "Stack");
        String expectedValue = "Queue";
        customHashMap.put('Y', expectedValue);
        // when
        String keyY = customHashMap.get('Y');
        // then
        assertEquals(expectedValue, keyY);
        assertEquals(2, customHashMap.size());
    }

    @Test
    public void shouldReturnTrueWhenContainsValueCalledForUniqueElementInTheBucketGivenBucketWithTwoElement() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "ArrayList");
        // when
        boolean hasValue = customHashMap.containsValue("ArrayList");
        // then
        assertTrue(hasValue);
    }

    @Test
    public void shouldContainAllInsertedValues() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('B', "ArrayList");
        customHashMap.put('C', "LinkedList");
        customHashMap.put('D', "HashMap");
        customHashMap.put('E', "HashSet");
        customHashMap.put('Y', "Stack");
        // when
        boolean hasArray = customHashMap.containsValue("Array");
        boolean hasArrayList = customHashMap.containsValue("ArrayList");
        boolean hasLinkedList = customHashMap.containsValue("LinkedList");
        boolean hasHashMap = customHashMap.containsValue("HashMap");
        boolean hasHashSet = customHashMap.containsValue("HashSet");
        boolean hasStack = customHashMap.containsValue("Stack");
        // then
        assertTrue(hasArray);
        assertTrue(hasArrayList);
        assertTrue(hasLinkedList);
        assertTrue(hasHashMap);
        assertTrue(hasHashSet);
        assertTrue(hasStack);
    }

    @Test
    public void shouldReturnFalseWhenBucketDoesNotHaveValue() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "ArrayList");
        // when
        boolean isContainKey = customHashMap.containsValue("HashMap");
        // then
        assertFalse(isContainKey);
    }

    @Test
    public void shouldReturnFalseWhenBucketDoesNotHaveKey() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "ArrayList");
        // when
        boolean isContainKey = customHashMap.containsKey('B');
        // then
        assertFalse(isContainKey);
    }

    @Test
    public void shouldDoRehash() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('B', "ArrayList");
        customHashMap.put('C', "LinkedList");
        System.out.println("customHashMap = " + customHashMap);
        // when
        customHashMap.put('D', "HashMap");
        // then
        System.out.println("customHashMap = " + customHashMap);
    }

    @Test
    public void shouldAcceptNullAsKey() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();

        // when
        customHashMap.put(null, "Array");
        // then
        assertTrue(customHashMap.size() != 0);
    }

    @Test
    public void shouldUpdateValueWithNullKey() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put(null, "Array");
        customHashMap.put(null, "ArrayList");
        // when
        String valueForNullKey = customHashMap.get(null);
        // then
        assertEquals("ArrayList", valueForNullKey);
    }
}
