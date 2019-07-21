import Html from './html.js'

describe("Html", () => {

    describe("create", () => {

        describe("should return new html object", () => {


            test("should be an object", () => {

                expect(typeof Html().create('h1')).toBe('object');

            })

            test('Throws an error if no element is passed', () => {
                expect(() => {
                    Html().create()
                }).toThrow('Must pass a HTML element')

            })

            test('Throws an error if an invalid element is passed', () => {
                expect(() => {
                    Html().create('asdfasd')
                }).toThrow('Invalid html element')

                
            })
        })

    })
    describe('add-class', () =>{
        test("should add a class to a element", ()=> {
            Html().create('div')
            const div = Html().create('div')
            div.addClass('newClass')
            expect(() => {
                div.render().classList.contains('newClass')
        
            })


        })
        test("should not add duplicate", () => {
            Html().create('div')
            const div = Html().create('div')
            div.addClass('newClass')
            expect(() => {
                div.addClass('newClass')
        
            })
            .toThrow('duplicate class error')
        })

    })
    describe('render', () => {
        test("should return element", () => {
            expect(
                Html().create('div').render() instanceof HTMLDivElement)
          
        })
    })
    describe('add child', () => {
        test('should add child', () => {
            const div = Html().create('div')
            const li = Html().create('li')
            div.addChild(li)
            expect(div.render().querySelector("li")).toEqual(li.render());
        })
    })
    describe('replace', () => {
        test('should replace inner Html',() => {
            const underTest = Html().create("nav");
            const firstChildToAdd = Html().create('li')
            const childToReplace = Html().create('a')
            underTest.addChild(firstChildToAdd);
            underTest.replace(childToReplace);
            expect(underTest.render().querySelector('a')).toEqual(childToReplace.render());
            expect(underTest.render().querySelectorAll('li')).length.toEqual(0)

        })
    })    
})