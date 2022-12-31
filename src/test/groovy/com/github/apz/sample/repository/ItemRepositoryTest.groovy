package com.github.apz.sample.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
@Unroll
class ItemRepositoryTest extends Specification{
    @Autowired
    ItemRepository itemRepository

    def "検索テスト"() {
        when:
        def result = itemRepository.findById($id)

        then:
        result.size() == 1
        result.get(0).getId() == _id
        result.get(0).getName() == _name

        where:
        $id || _id | _name
        '1' || 1L  | '商品'
    }
}
