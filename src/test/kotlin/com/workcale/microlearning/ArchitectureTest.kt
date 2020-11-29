package com.workcale.microlearning

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

/**
 * This test use archunit : https://www.archunit.org
 * It's purpose is to enforce the architecture Rules
 */
@AnalyzeClasses(packages = ["com.workcale.microlearning"])
class ArchitectureTest {

    /**
     * Enforce the Hexagonal Architecture and check that we don't break dependencies rules
     */
    @ArchTest
    val appMustNotDependOfInfra:Any = ArchRuleDefinition
            .noClasses().that().resideInAPackage("..application..")
            .should().dependOnClassesThat().resideInAPackage("..infrastructure..")

    @ArchTest
    val infraMustNotDependOfApp:Any = ArchRuleDefinition
            .noClasses().that().resideInAPackage("..infrastructure..")
            .should().dependOnClassesThat().resideInAPackage("..application..")

    @ArchTest
    val domainMustNotDependOfApp:Any = ArchRuleDefinition
            .noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAPackage("..application..")

    @ArchTest
    val domainMustNotDependOfInfra:Any = ArchRuleDefinition
            .noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAPackage("..infrastructure..")

}