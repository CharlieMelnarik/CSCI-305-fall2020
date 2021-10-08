        program SuperSpy
        Implicit none
        call printout
        end program SuperSpy

        subroutine calc
        Implicit none
        Integer hat, i, hatn, dig, str
        write (*,*) 'Hat size?'
        read (*,*) hat
        if (hat <1000 .OR. hat >1000000) then
                print *,"input number within bounds"
        Else

                !The math to find the 4th and last number using mod
                hatn = modulo(hat, 10)
                dig = modulo(hat, 10000)/1000

                !concatinate the two integers to str
                str = hatn * 10**(ceiling(log10(real(dig))))+dig

                print *, "Use",str
                return
        End if
        end subroutine calc

        subroutine printout
        Implicit none
        call calc
        end subroutine printout
