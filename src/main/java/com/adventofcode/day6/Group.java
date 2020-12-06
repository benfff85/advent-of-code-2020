package com.adventofcode.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.frequency;

public class Group {

    private final Set<Person> people = new HashSet<>();

    public void add(Person person) {
        people.add(person);
    }

    public Set<String> getQuestionsAnsweredYesByAnyone() {
        Set<String> questions = new HashSet<>();
        people.forEach(person -> questions.addAll(person.getQuestions()));
        return questions;
    }

    public Set<String> getQuestionsAnsweredYesByEveryone() {
        List<String> questions = new ArrayList<>();
        people.forEach(person -> questions.addAll(person.getQuestions()));

        Set<String> questionsAnsweredYesByAll = new HashSet<>();
        for (String question : getQuestionsAnsweredYesByAnyone()) {
            if (frequency(questions, question) == people.size()) {
                questionsAnsweredYesByAll.add(question);
            }
        }
        return questionsAnsweredYesByAll;
    }

}
