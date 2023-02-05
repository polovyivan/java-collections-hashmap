package com.polovyi.ivan.tutorials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        assertNull(customHashMap.get('A'));
        assertFalse(customHashMap.containsKey('A'));
    }

    @Test
    public void shouldRemoveFirstElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('E', "Stack");
        customHashMap.put('Y', "Queue");
        // when
        customHashMap.remove('A');
        // then
        assertEquals(2, customHashMap.size());
        assertTrue(customHashMap.containsKey('E'));
        assertTrue(customHashMap.containsKey('Y'));
    }

    @Test
    public void shouldRemoveSecondElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('E', "Stack");
        customHashMap.put('Y', "Queue");
        System.out.println("customHashMap = " + customHashMap);
        // when
        customHashMap.remove('E');
        // then
        assertEquals(2, customHashMap.size());
        assertTrue(customHashMap.containsKey('A'));
        assertTrue(customHashMap.containsKey('Y'));
        System.out.println("customHashMap = " + customHashMap);
    }

    @Test
    public void shouldRemoveLastElementFromHashMapBucket() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        customHashMap.put('E', "Stack");
        customHashMap.put('Y', "Queue");
        System.out.println("customHashMap = " + customHashMap);
        // when
        customHashMap.remove('Y');
        // then
        assertEquals(2, customHashMap.size());
        assertTrue(customHashMap.containsKey('A'));
        assertTrue(customHashMap.containsKey('E'));
        System.out.println("customHashMap = " + customHashMap);
    }

    @Test
    public void shouldRemoveAllElementFromHashMap() {
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
        assertNull(customHashMap.get('A'));
        assertFalse(customHashMap.containsKey('A'));
        assertNull(customHashMap.get('B'));
        assertFalse(customHashMap.containsKey('B'));
        assertNull(customHashMap.get('C'));
        assertFalse(customHashMap.containsKey('C'));
        assertNull(customHashMap.get('D'));
        assertFalse(customHashMap.containsKey('D'));
        assertNull(customHashMap.get('E'));
        assertFalse(customHashMap.containsKey('E'));
        assertNull(customHashMap.get('Y'));
        assertFalse(customHashMap.containsKey('Y'));
    }

    @Test
    public void shouldReturnNullWhenRemoveCalledWithNonExistentKey() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        // when
        String removedElementValue = customHashMap.remove('Y');
        // then
        assertEquals(1, customHashMap.size());
        assertNull(removedElementValue);
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
    public void shouldReturnTrueWhenContainsKeyCalledForEveryElementInMap() {
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
    public void shouldReturnNullWhenGetCalledWithNonexistentKey() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        customHashMap.put('A', "Array");
        // when
        String value = customHashMap.get('B');
        // then
        assertNull(value);
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
    public void shouldReturnTrueWhenContainsValueCalledForUniqueElementInTheBucket() {
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
        Character aKey = 'A';
        String aValue = "Array";
        customHashMap.put(aKey, aValue);
        Character cKey = 'C';
        String cValue = "LinkedList";
        customHashMap.put(cKey, cValue);
        Character dKey = 'D';
        String dValue = "HashMap";
        // when
        customHashMap.put(dKey, dValue);
        // then
        assertEquals(3, customHashMap.size());
        assertEquals(aValue, customHashMap.get(aKey));
        assertEquals(cValue, customHashMap.get(cKey));
        assertEquals(dValue, customHashMap.get(dKey));
    }

    @Test
    public void shouldDoRehashWhenBucketHasMoreThanOneElement() {
        // given
        CustomHashMap<Character, String> customHashMap = new CustomHashMapImpl();
        Character aKey = 'A';
        String aValue = "Array";
        customHashMap.put(aKey, aValue);
        Character eKey = 'E';
        String eValue = "ArrayList";
        customHashMap.put(eKey, eValue);
        Character cKey = 'C';
        String cValue = "LinkedList";
        customHashMap.put(cKey, cValue);
        Character dKey = 'D';
        String dValue = "HashMap";
        // when
        customHashMap.put(dKey, dValue);
        // then
        assertEquals(4, customHashMap.size());
        assertEquals(aValue, customHashMap.get(aKey));
        assertEquals(eValue, customHashMap.get(eKey));
        assertEquals(cValue, customHashMap.get(cKey));
        assertEquals(dValue, customHashMap.get(dKey));
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
